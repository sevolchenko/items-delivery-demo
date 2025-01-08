package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import java.util.UUID

@Repository
interface ApplicationRepository : JpaRepository<Application, UUID>
