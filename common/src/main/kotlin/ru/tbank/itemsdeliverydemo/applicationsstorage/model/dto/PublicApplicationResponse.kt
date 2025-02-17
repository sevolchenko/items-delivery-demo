package ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus

data class PublicApplicationResponse(
    val integrationId: String,
    val status: ApplicationStatus
)
