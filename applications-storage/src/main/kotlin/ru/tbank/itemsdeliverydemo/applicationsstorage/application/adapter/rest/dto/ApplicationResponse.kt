package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ApplicationStatus
import java.time.LocalDateTime

data class ApplicationResponse(
    val integrationId: String,
    val status: ApplicationStatus,
    val products: List<ProductResponse>,
    val createdAt: LocalDateTime
)
