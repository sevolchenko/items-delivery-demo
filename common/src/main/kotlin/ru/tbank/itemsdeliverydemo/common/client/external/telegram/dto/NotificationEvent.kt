package ru.tbank.itemsdeliverydemo.common.client.external.telegram.dto

data class NotificationEvent(
    val clientId: Long,
    val message: String
)
