package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.common.handling.ErrorResponse
import ru.tbank.itemsdeliverydemo.itemscontroller.item.ItemService
import ru.tbank.itemsdeliverydemo.itemscontroller.model.dto.CreateItemRequest
import java.util.UUID

@Tag(name = "Maintenance")
@RestController
@RequestMapping("/api/v1/maintenance")
class MaintenanceController(
    private val itemService: ItemService
) {
    @Operation(
        summary = "Добавить элементы с одинаковыми параметрами",
        description = "Добавляет элеметы с одинаковым цветом и типом, и возвращает массив их id",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Элементы успешно добавлены",
                content = [
                    Content(
                        schema = Schema(implementation = Array<UUID>::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Неверные параметры запроса",
                content = [
                    Content(
                        schema = Schema(implementation = ErrorResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @PostMapping("/create")
    fun createItem(
        @Valid @RequestBody request: CreateItemRequest
    ): ResponseEntity<*> {
        val createdItemsId = itemService.createItems(request.type, request.color, request.quantity)

        return ResponseEntity.ok().body(createdItemsId)
    }
}
