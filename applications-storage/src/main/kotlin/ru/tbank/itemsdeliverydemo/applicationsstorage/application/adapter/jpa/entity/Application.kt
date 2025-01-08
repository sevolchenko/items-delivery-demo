package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ApplicationStatus
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "application")
data class Application(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Enumerated(EnumType.STRING)
    var status: ApplicationStatus = ApplicationStatus.CREATED,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
