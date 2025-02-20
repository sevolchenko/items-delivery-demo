package ru.tbank.itemsdeliverydemo.itemskeeper.model.dto

import jakarta.validation.constraints.Min

data class CreateCellsRequest(
    val namePrefix: String,

    val length: Double,
    val height: Double,
    val width: Double,

    @field:Min(1)
    val quantity: Int
)
