package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "application")
data class Application(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val integrationId: String = UUID.randomUUID().toString(),

    val clientId: Long? = null,

    @Enumerated(EnumType.STRING)
    var status: ApplicationStatus = ApplicationStatus.CREATED,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "application_id")
    val products: List<Product> = emptyList(),

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
