package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ProductType
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val integrationId: String = UUID.randomUUID().toString(),

    val type: ProductType? = null,

    val customText: String? = null,

    var itemNumber: String? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
