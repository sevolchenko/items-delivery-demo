package ru.tbank.itemsdeliverydemo.notificationcenter.model.dto

data class NotificationEvent(
    val clientId: Long,
    val message: String
)
