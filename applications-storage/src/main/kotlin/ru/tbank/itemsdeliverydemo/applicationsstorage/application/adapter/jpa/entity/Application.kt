package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ApplicationStatus
import java.time.LocalDateTime

@Entity
@Table(name = "application")
data class Application(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @GeneratedValue(strategy = GenerationType.UUID)
    val integrationId: String? = null,

    var pickupCode: String? = null,

    @Enumerated(EnumType.STRING)
    var status: ApplicationStatus = ApplicationStatus.CREATED,

    @OneToMany
    val products: List<Product> = emptyList(),

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
