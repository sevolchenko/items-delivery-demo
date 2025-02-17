package ru.tbank.itemsdeliverydemo.itemskeeper.cell.model.dto

import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions

data class CreateCellRequest(
    val cellName: String,
    val cellDimensions: CellDimensions
)
