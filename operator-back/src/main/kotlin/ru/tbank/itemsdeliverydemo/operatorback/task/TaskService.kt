package ru.tbank.itemsdeliverydemo.operatorback.task

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.TaskRepository
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import kotlin.jvm.optionals.getOrNull

@Service
class TaskService(
    private val repository: TaskRepository
) {

    fun getTask(
        taskId: String
    ): Task? {
        return repository.findTaskByTaskId(taskId).getOrNull()
    }
}
