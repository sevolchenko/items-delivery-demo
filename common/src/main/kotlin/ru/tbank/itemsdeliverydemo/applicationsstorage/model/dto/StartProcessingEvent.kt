package ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto

data class StartProcessingEvent(
    val event: String,
    val applicationId: String
)
