package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ItemStatus
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = UUID.randomUUID().toString(),

    @Enumerated(EnumType.STRING)
    val type: ProductType? = null,
    val color: String? = null,

    @Enumerated(EnumType.STRING)
    var status: ItemStatus = ItemStatus.AVAILABLE,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
