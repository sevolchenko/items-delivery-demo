package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val type: String = "Default",
    val color: String? = null,

    @Enumerated(EnumType.STRING)
    var status: ItemStatus = ItemStatus.AVAILABLE,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
