package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.itemscontroller.item.ItemService
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto.ErrorResponse
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto.ReserveItemRequest
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto.ReserveItemResponse

@Tag(name = "Items")
@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val itemService: ItemService
) {

    @Operation(
        summary = "Зарезервировать товар по параметрами",
        description = "Ищет товар со статусом AVAILABLE, меняет его статус на RESERVED и возвращает его id",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Запрос успешно выполнен",
                content = [
                    Content(
                        schema = Schema(implementation = ReserveItemResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Нет доступных товаров с такими параметрами",
                content = [
                    Content(
                        schema = Schema(implementation = ErrorResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @PostMapping("/reserve")
    fun reserveItem(
        @RequestBody request: ReserveItemRequest
    ): ResponseEntity<*> {
        val reservedItemId = itemService.reserveItem(request.type, request.color)
            ?: return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(ErrorResponse("No available item found"))

        return ResponseEntity.ok().body(ReserveItemResponse(reservedItemId))
    }
}
