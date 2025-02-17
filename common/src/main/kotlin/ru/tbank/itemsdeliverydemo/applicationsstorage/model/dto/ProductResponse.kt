package ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto

import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import java.time.LocalDateTime

data class ProductResponse(
    val integrationId: String,
    val itemNumber: String? = null,
    val type: ProductType,
    val customText: String? = null,
    val createdAt: LocalDateTime
)
