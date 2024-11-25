package ru.tbank.itemsdeliverydemo.applicationsstorage.application.model

enum class ApplicationStatus {
    CREATED,
    RESERVED,
    OPERATOR_PROCESSING,
    READY_TO_RECEIVE,
    COMPLETED,
    REJECTED
}