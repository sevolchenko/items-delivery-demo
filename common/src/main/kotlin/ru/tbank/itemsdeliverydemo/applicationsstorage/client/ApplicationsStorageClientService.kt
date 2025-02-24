package ru.tbank.itemsdeliverydemo.applicationsstorage.client

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto.ApplicationResponse

class ApplicationsStorageClientService(
    private val webClient: WebClient,
) {

    fun getApplication(
        applicationId: String
    ): ApplicationResponse {
        return webClient.get()
            .uri("/api/v1/applications/$applicationId")
            .retrieve()
            .bodyToMono(ApplicationResponse::class.java)
            .block()!!
    }

    fun updateApplicationStatus(
        applicationId: String,
        status: ApplicationStatus
    ) {
        webClient.patch()
            .uri {
                it
                    .path("/api/v1/applications/$applicationId/status")
                    .queryParam("status", status)
                    .build()
            }
            .retrieve()
            .bodyToMono(ApplicationResponse::class.java)
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
                    .path("/api/v1/applications/$applicationId/products/$productId")
                    .queryParam("itemNumber", itemNumber)
                    .build()
            }
            .retrieve()
            .bodyToMono(ApplicationResponse::class.java)
            .block()
    }
}
