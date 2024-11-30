package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto

import java.util.UUID

data class CreateItemResponse(
    val createdItemId: List<UUID>
)
