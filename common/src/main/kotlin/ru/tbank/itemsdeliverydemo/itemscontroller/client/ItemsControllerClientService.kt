package ru.tbank.itemsdeliverydemo.itemscontroller.client

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.itemscontroller.client.configuration.ItemsControllerClientConfiguration
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.ReserveItemRequest
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.ReserveItemResponse

@Service
@ConditionalOnProperty(prefix = "service.items-controller", name = ["enabled"], havingValue = "true")
class ItemsControllerClientService(
    private val webClient: WebClient,
    private val conf: ItemsControllerClientConfiguration,
) {

    fun reserveItem(type: ProductType, color: String?): ReserveItemResponse {
        val request = ReserveItemRequest(type, color)
        return webClient.post()
            .uri("${conf.host}/api/v1/items/reserve")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(ReserveItemResponse::class.java)
            .block()!!
    }
}
