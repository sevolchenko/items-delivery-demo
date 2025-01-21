package ru.tbank.itemsdeliverydemo.itemskeeper.cellcharacteristics.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "cell_dimensions")
data class CellDimensions(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val length: Double = 1.0,
    val height: Double = 1.0,
    val width: Double = 1.0
)
