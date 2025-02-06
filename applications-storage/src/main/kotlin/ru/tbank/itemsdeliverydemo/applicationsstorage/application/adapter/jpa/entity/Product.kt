package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ProductType
import java.time.LocalDateTime

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @GeneratedValue(strategy = GenerationType.UUID)
    val integrationId: String? = null,

    val type: ProductType? = null,

    val customText: String? = null,

    @ManyToOne
    val application: Application? = null,

    var itemNumber: String? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
