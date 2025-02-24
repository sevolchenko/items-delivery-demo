package ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "cell_dimensions")
data class CellDimensions(
    @Id
    val id: String? = UUID.randomUUID().toString(),

    val length: Double = 1.0,
    val height: Double = 1.0,
    val width: Double = 1.0
)
