package ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus
import java.time.LocalDateTime

data class ApplicationResponse(
    val integrationId: String,
    val status: ApplicationStatus,
    val products: List<ProductResponse>,
    val createdAt: LocalDateTime
)
