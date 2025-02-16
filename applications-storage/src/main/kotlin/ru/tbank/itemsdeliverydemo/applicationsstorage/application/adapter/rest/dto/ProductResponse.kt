package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ProductType
import java.time.LocalDateTime

data class ProductResponse(
    val integrationId: String,
    val itemNumber: String? = null,
    val type: ProductType,
    val customText: String? = null,
    val createdAt: LocalDateTime
)
