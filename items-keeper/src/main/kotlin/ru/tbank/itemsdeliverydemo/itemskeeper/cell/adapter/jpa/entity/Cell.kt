package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions
import java.util.UUID

@Entity
@Table(name = "cell")
data class Cell(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val name: String? = "Default",

    @ManyToOne
    val cellDimensions: CellDimensions? = null
)
