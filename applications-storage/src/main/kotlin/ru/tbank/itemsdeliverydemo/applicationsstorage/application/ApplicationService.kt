package ru.tbank.itemsdeliverydemo.applicationsstorage.application

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.ApplicationRepository
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Product
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.CreateApplicationRequest
import kotlin.jvm.optionals.getOrNull

@Service
class ApplicationService(
    private val repository: ApplicationRepository
) {

    fun getApplication(
        integrationId: String
    ): Application? {
        return repository.findApplicationByIntegrationId(integrationId).getOrNull()
    }

    fun createApplication(
        request: CreateApplicationRequest
    ): Application {
        val product = Product(
            type = request.productType,
            customText = request.customText
        )

        val application = Application(products = listOf(product))

        return repository.save(application)
    }

}
