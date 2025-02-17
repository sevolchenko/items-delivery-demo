package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.rest.dto

import ru.tbank.itemsdeliverydemo.operatorback.task.model.TaskStatus

data class TaskResponse(
    val taskId: String,
    val status: TaskStatus
)
