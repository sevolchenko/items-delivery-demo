package ru.tbank.itemsdeliverydemo.itemskeeper.client

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration.ItemsKeeperClientConfiguration
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.CreatePlacementResponse
import java.time.LocalDateTime

@Service
@ConditionalOnProperty(prefix = "service.items-controller", name = ["enabled"], havingValue = "true")
class ItemsKeeperClientService(
    private val webClient: WebClient,
    private val conf: ItemsKeeperClientConfiguration,
) {

    fun placeProduct(
        productId: String
    ): CreatePlacementResponse {
        webClient
        conf
        productId
        finishPlacement("")

        return CreatePlacementResponse(
            placementId = "PLACEMENT_ID",
            cellId = "CELL_ID",
            validUntil = LocalDateTime.now().plusDays(1)
        )
    }

    fun finishPlacement(
        placementId: String
    ) {
        listOf(placementId)
    }
}
