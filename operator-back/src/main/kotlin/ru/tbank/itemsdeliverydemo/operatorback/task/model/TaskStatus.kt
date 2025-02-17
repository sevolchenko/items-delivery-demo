package ru.tbank.itemsdeliverydemo.operatorback.task.model

enum class TaskStatus {
    WAITING_FOR_HANDLING,
    HANDLING,
    WAITING_FOR_PICKUP,
    FINISHED,
    CANCELLED
}
