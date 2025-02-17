package ru.tbank.itemsdeliverydemo.operatorback.model.dto

import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus

data class TaskResponse(
    val taskId: String,
    val status: TaskStatus
)
