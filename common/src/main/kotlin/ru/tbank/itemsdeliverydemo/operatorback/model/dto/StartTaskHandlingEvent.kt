package ru.tbank.itemsdeliverydemo.operatorback.model.dto

import ru.tbank.itemsdeliverydemo.operatorback.model.TaskType

data class StartTaskHandlingEvent(
    val applicationId: String,
    val taskType: TaskType
)
