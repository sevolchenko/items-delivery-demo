package ru.tbank.itemsdeliverydemo.itemscontroller.model.dto

import jakarta.validation.constraints.Min
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

data class CreateItemRequest(
    val type: ProductType,
    val color: String? = null,
    @field:Min(1)
    val quantity: Int
)
