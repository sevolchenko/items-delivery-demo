package ru.tbank.itemsdeliverydemo.applicationsstorage.model

enum class ApplicationStatus {
    CREATED,
    RESERVED,
    WAITING_FOR_TAKE,
    OPERATOR_PROCESSING,
    READY_TO_RECEIVE,
    COMPLETED,
    REJECTED;

    companion object {
        val finalStatuses = listOf(COMPLETED, REJECTED)
    }
}
