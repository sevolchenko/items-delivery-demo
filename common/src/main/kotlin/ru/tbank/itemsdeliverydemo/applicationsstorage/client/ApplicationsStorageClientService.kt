package ru.tbank.itemsdeliverydemo.applicationsstorage.client

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.configuration.ApplicationsStorageClientConfiguration
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto.ApplicationResponse

@Service
@ConditionalOnProperty(prefix = "service.applications-storage", name = ["enabled"], havingValue = "true")
class ApplicationsStorageClientService(
    private val webClient: WebClient,
    private val conf: ApplicationsStorageClientConfiguration,
) {

    fun getApplication(
        applicationId: String
    ): ApplicationResponse {
        return webClient.get()
            .uri("${conf.host}/api/v1/applications/$applicationId")
            .retrieve()
            .bodyToMono(ApplicationResponse::class.java)
            .block()!!
    }

    fun updateApplicationStatus(
        applicationId: String,
        status: ApplicationStatus
    ) {
        webClient.patch()
            .uri("${conf.host}/api/v1/applications/$applicationId/status")
            .bodyValue(status)
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

    fun updateProduct(
        applicationId: String,
        productId: String,
        itemNumber: String
    ) {
        webClient.put()
            .uri {
                it
                    .path("${conf.host}/api/v1/applications/$applicationId/products/$productId")
                    .queryParam("itemNumber", itemNumber)
                    .build()
            }
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }
}
