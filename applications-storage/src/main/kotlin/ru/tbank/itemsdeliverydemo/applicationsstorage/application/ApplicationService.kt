package ru.tbank.itemsdeliverydemo.applicationsstorage.application

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.ApplicationRepository
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Product
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.CreateApplicationRequest
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ApplicationStatus
import ru.tbank.itemsdeliverydemo.applicationsstorage.component.KafkaProducer
import ru.tbank.itemsdeliverydemo.applicationsstorage.component.ProcessingStarter
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class ApplicationService(
    private val repository: ApplicationRepository,
    private val processingStarter: ProcessingStarter
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

        return repository.save(application).also {
            processingStarter.startProcessing(it.integrationId)
        }
    }

    fun updateApplicationStatus(
        integrationId: String,
        status: ApplicationStatus
    ): Application? {
        return getApplication(integrationId)?.apply {
            this.status = status
            updatedAt = LocalDateTime.now()
        }
    }

    fun updateApplication(
        integrationId: String,
        pickupCode: String
    ): Application? {
        return getApplication(integrationId)?.apply {
            this.pickupCode = pickupCode
            updatedAt = LocalDateTime.now()
        }
    }

    fun updateProduct(
        applicationId: String,
        productId: String,
        itemNumber: String
    ): Application? {
        return getApplication(applicationId)?.apply {
            products
                .find { it.integrationId == productId }
                ?.apply {
                    this.itemNumber = itemNumber
                }
            updatedAt = LocalDateTime.now()
        }
    }
}
