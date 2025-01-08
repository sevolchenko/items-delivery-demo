package ru.tbank.itemsdeliverydemo.applicationsstorage.application

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.ApplicationRepository
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import kotlin.jvm.optionals.getOrNull

@Service
class ApplicationService(
    private val repository: ApplicationRepository
) {

    fun getApplication(
        id: String
    ): Application? {
        return repository.findApplicationByIntegrationId(id).getOrNull()
    }

}
