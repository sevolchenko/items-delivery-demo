package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ApplicationStatus

data class PublicApplicationResponse(
    val integrationId: String,
    val status: ApplicationStatus
)
