package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import java.util.Optional

@Repository
interface TaskRepository : JpaRepository<Task, Long> {

    fun findTaskByTaskId(taskId: String): Optional<Task>

    fun findTasksByStatus(status: TaskStatus): List<Task>

    fun findTaskByPickupCode(pickupCode: String): Optional<Task>
}
