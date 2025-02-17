package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskType
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "task")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val taskId: String = UUID.randomUUID().toString(),

    val applicationId: String? = null,

    var placementId: String? = null,

    var pickupCode: String? = null,

    @Enumerated(EnumType.STRING)
    val type: TaskType? = null,

    @Enumerated(EnumType.STRING)
    var status: TaskStatus = TaskStatus.WAITING_FOR_HANDLING,

    var operatorId: String? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
