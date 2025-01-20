package ru.tbank.itemsdeliverydemo.itemskeeper.keeper.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.keeper.model.KeeperStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "keeper")
data class Keeper(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val productId: UUID? = null,

    @ManyToOne
    val cellId: Cell? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var status: KeeperStatus = KeeperStatus.FREE,
)
