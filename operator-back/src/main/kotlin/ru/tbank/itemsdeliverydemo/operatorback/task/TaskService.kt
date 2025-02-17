package ru.tbank.itemsdeliverydemo.operatorback.task

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.operatorback.streaming.TaskStatusUpdatedSender
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.TaskRepository
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import ru.tbank.itemsdeliverydemo.operatorback.task.model.TaskStatus
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class TaskService(
    private val repository: TaskRepository,
    private val taskStatusUpdatedSender: TaskStatusUpdatedSender
) {

    fun getTask(
        taskId: String
    ): Task? {
        return repository.findTaskByTaskId(taskId).getOrNull()
    }

    fun updateTaskStatus(
        task: Task,
        newStatus: TaskStatus
    ) = task.apply {
            status = newStatus
            updatedAt = LocalDateTime.now()
        }.also {
            taskStatusUpdatedSender.sendStatusUpdated(it)
        }
}
