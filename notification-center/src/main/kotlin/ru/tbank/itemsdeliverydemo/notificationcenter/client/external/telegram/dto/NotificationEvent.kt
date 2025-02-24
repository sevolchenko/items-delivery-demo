package ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.dto

data class NotificationEvent(
    val clientId: Long,
    val message: String
)
