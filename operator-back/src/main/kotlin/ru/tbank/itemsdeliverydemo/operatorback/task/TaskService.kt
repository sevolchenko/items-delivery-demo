package ru.tbank.itemsdeliverydemo.operatorback.task

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.product
import ru.tbank.itemsdeliverydemo.itemskeeper.client.ItemsKeeperClientService
import ru.tbank.itemsdeliverydemo.operatorback.component.InstructionsBuilder
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskType
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TakeTaskRequest
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TakeTaskResponse
import ru.tbank.itemsdeliverydemo.operatorback.streaming.TaskStatusUpdatedSender
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.TaskRepository
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class TaskService(
    private val repository: TaskRepository,
    private val statusUpdatedSender: TaskStatusUpdatedSender,
    private val instructionsBuilder: InstructionsBuilder,
    private val itemsKeeper: ItemsKeeperClientService,
    private val storage: ApplicationsStorageClientService
) {

    fun getTask(
        taskId: String
    ): Task? {
        return repository.findTaskByTaskId(taskId).getOrNull()
    }

    fun createTask(
        applicationId: String,
        type: TaskType
    ): Task {
        val task = Task(
            applicationId = applicationId,
            type = type
        )

        return repository.save(task).also {
            statusUpdatedSender.sendStatusUpdated(it)
        }
    }

    fun takeTask(
        request: TakeTaskRequest
    ): TakeTaskResponse? {
        val task = findEarliestPendingTask() ?: return null

        task.operatorId = request.operatorId

        val product = storage.getApplication(task.applicationId!!).product()

        val cellId = itemsKeeper.placeProduct(product.integrationId)
            .also {
                task.placementId = it.placementId
            }.cellId

        val instructions = instructionsBuilder.buildInstructionsFor(
            task.type!!,
            product.type,
            product.customText,
            cellId
        )

        return TakeTaskResponse(
            taskId = task.taskId,
            instructions = instructions
        ).also {
            updateTaskStatus(task, TaskStatus.HANDLING)
        }
    }

    private fun findEarliestPendingTask(): Task? {
        val pendingTasks = repository.findTasksByStatus(TaskStatus.WAITING_FOR_HANDLING)

        if (pendingTasks.isEmpty()) { return null }

        return pendingTasks.minBy { it.createdAt }
    }

    fun updateTaskStatus(
        task: Task,
        newStatus: TaskStatus
    ) = task.apply {
        status = newStatus
        updatedAt = LocalDateTime.now()
    }.also {
        statusUpdatedSender.sendStatusUpdated(it)
    }
}
