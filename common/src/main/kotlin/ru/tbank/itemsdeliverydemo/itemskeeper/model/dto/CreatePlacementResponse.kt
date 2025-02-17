package ru.tbank.itemsdeliverydemo.itemskeeper.model.dto

import java.time.LocalDateTime

data class CreatePlacementResponse(
    val placementId: String,
    val cellId: String,
    val validUntil: LocalDateTime
)
