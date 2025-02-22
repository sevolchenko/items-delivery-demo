package ru.tbank.itemsdeliverydemo.itemskeeper.client

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration.ItemsKeeperClientConfiguration
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.FinishPlacementRequest
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.PlaceProductRequest
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.PlacementResponse

class ItemsKeeperClientService(
    private val webClient: WebClient,
    private val conf: ItemsKeeperClientConfiguration,
) {

    fun placeProduct(
        productId: String
    ): PlacementResponse {
        return webClient.post()
            .uri("${conf.host}/api/v1/placement/create")
            .bodyValue(PlaceProductRequest(productId))
            .retrieve()
            .bodyToMono(PlacementResponse::class.java)
            .block()!!
    }

    fun finishPlacement(
        placementId: String
    ): PlacementResponse {
        return webClient.post()
            .uri("${conf.host}/api/v1/placement/finish")
            .bodyValue(FinishPlacementRequest(placementId))
            .retrieve()
            .bodyToMono(PlacementResponse::class.java)
            .block()!!
    }
}
