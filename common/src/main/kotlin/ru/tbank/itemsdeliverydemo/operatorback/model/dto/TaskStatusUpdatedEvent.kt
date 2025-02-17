package ru.tbank.itemsdeliverydemo.operatorback.model.dto

import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus

data class TaskStatusUpdatedEvent(
    val taskId: String,
    val applicationId: String,
    val status: TaskStatus,
    val pickupCode: String? = null
)
