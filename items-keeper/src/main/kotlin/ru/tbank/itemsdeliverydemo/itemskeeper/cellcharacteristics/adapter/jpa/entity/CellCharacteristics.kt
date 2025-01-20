package ru.tbank.itemsdeliverydemo.itemskeeper.cellcharacteristics.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "cell_characteristic")
data class CellCharacteristics(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val length: Double = 0.0,
    val height: Double = 0.0,
    val width: Double = 0.0
)
