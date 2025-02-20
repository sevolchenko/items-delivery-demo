package ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.rest

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.CellService
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.CreateCellsRequest
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.FinishPlacementRequest
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.PlaceProductRequest
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.PlacementResponse
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.PlacementService

@Tag(name = "placement")
@RestController
@RequestMapping("/api/v1/placement")
class PlacementController(
    private val placementService: PlacementService
) {
    @PostMapping("/create")
    fun placeProduct(
        @RequestBody request: PlaceProductRequest
    ): ResponseEntity<*> {
        return placementService.placeProduct(request.productId).let {
            PlacementResponse(placementId = it.id!!, cellId =  it.cell!!.id)
        }.let { ResponseEntity.ok().body(it) }
    }

    @PostMapping("/finish")
    fun finishPlacement(
        @RequestBody request: FinishPlacementRequest
    ): ResponseEntity<*> {
        return placementService.finishPlacement(request.placementId)?.let {
            PlacementResponse(placementId = it.id!!, cellId = it.cell!!.id)
        }.let { ResponseEntity.ok().body(it) }
    }
}
