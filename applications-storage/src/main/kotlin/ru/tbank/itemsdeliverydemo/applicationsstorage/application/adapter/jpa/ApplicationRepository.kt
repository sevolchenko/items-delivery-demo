package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application

@Repository
interface ApplicationRepository : JpaRepository<Application, Long>