package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemskeeper.cellcharacteristics.adapter.jpa.entity.CellDimensions
import java.util.UUID

@Entity
@Table(name = "cell")
data class Cell(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    val name: String = "Default",

    @ManyToOne
    val cellDimensions: CellDimensions? = null
)
