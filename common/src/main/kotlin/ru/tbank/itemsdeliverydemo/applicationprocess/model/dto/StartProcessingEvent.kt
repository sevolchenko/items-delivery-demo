package ru.tbank.itemsdeliverydemo.applicationprocess.model.dto

data class StartProcessingEvent(
    val event: EventType,
    val applicationId: String
)

enum class EventType {
    START
}
