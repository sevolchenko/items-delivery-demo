package ru.tbank.itemsdeliverydemo.itemskeeper.client

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration.ItemsKeeperClientConfiguration
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.PlacementResponse

@Service
@ConditionalOnProperty(prefix = "service.items-controller", name = ["enabled"], havingValue = "true")
class ItemsKeeperClientService(
    private val webClient: WebClient,
    private val conf: ItemsKeeperClientConfiguration,
) {

    fun placeProduct(
        productId: String
    ): PlacementResponse {
        webClient
        conf
        productId

        return PlacementResponse(
            placementId = "PLACEMENT_ID",
            cellId = "CELL_ID"
        )
    }

    fun finishPlacement(
        placementId: String
    ): PlacementResponse {
        return PlacementResponse(
            placementId,
            "CELL_ID"
        )
    }
}
