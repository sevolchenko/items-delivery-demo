package ru.tbank.itemsdeliverydemo.applicationsstorage.model

enum class ApplicationStatus {
    CREATED,
    RESERVED,
    OPERATOR_PROCESSING,
    READY_TO_RECEIVE,
    COMPLETED,
    REJECTED
}
