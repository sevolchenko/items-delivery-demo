package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto

import jakarta.validation.constraints.Min

data class CreateItemRequest(
    val type: String,
    val color: String?,
    @field:Min(1)
    val quantity: Int
)
