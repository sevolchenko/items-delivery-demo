package ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.model.KeeperStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "placement")
data class Placement(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val productId: UUID? = null,

    @ManyToOne
    val cell: Cell? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var status: KeeperStatus = KeeperStatus.FREE,
)
