package ru.tbank.itemsdeliverydemo.itemscontroller.client

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.ItemResponse
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.ReserveItemRequest
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.ReserveItemResponse

class ItemsControllerClientService(
    private val webClient: WebClient
) {

    fun reserveItem(type: ProductType, color: String? = null): ReserveItemResponse {
        val request = ReserveItemRequest(type, color)
        return webClient.post()
            .uri("/api/v1/items/reserve")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(ReserveItemResponse::class.java)
            .block()!!
    }

    fun findItemById(
        itemNumber: String
    ): ItemResponse {
        return webClient.get()
            .uri("/api/v1/items/$itemNumber")
            .retrieve()
            .bodyToMono(ItemResponse::class.java)
            .block()!!
    }
}
