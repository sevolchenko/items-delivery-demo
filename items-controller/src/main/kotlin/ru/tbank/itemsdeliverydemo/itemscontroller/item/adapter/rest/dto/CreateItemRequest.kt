package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

class CreateItemRequest(
    val type: String,
    val color: String?,
    @Min(1)
    @Max(100)
    val quantity: Int
)
