package ru.tbank.itemsdeliverydemo.itemskeeper.storagestatushistory.adapter.jpa.entity

import jakarta.persistence.Entity
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
@Table(name = "storage_status_history")
data class StorageStatusHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @ManyToOne
    val cellId: Cell? = null,

    val timestamp: LocalDateTime = LocalDateTime.now(),

    val newStatus: KeeperStatus? = null
)
