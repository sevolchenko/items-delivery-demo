package ru.tbank.itemsdeliverydemo.itemscontroller.model.dto

import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

data class ReserveItemRequest(
    val type: ProductType,
    val color: String?
)
