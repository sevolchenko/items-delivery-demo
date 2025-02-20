package ru.tbank.itemsdeliverydemo.itemscontroller.model.dto

import ru.tbank.itemsdeliverydemo.itemscontroller.model.ItemStatus
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

data class ItemResponse(
    val id: String,
    val type: ProductType,
    val color: String?,
    var status: ItemStatus = ItemStatus.AVAILABLE
)
