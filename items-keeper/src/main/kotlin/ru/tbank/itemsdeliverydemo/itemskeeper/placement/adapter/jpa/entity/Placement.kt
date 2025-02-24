package ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.model.PlacementStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "placement")
data class Placement(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val productId: String? = null,

    @ManyToOne
    val cell: Cell? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var status: PlacementStatus = PlacementStatus.BUSY,
)
