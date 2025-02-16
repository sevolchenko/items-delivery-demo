package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.ApplicationService
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.CreateApplicationRequest
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.PublicApplicationResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.PublicPickupCodeResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.common.ErrorResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.mapper.ApplicationMapper

@RestController
@RequestMapping("/public/api/v1/applications")
class PublicApplicationController(
    private val service: ApplicationService,
    private val mapper: ApplicationMapper
) {

    @Operation(
        summary = "Создать заявку",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Заявка успешно создана",
                content = [
                    Content(
                        schema = Schema(implementation = PublicApplicationResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @PostMapping("/create")
    fun createApplication(
        @RequestBody request: CreateApplicationRequest
    ): ResponseEntity<*> {
        return service.createApplication(request).toResponse()
    }

    @Operation(
        summary = "Получить статус заявки",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Заявка успешно получена",
                content = [
                    Content(
                        schema = Schema(implementation = PublicApplicationResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Заявка не найдена",
                content = [
                    Content(
                        schema = Schema(implementation = ErrorResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @GetMapping("/{id}/status")
    fun getApplicationStatus(
        @PathVariable id: String
    ): ResponseEntity<*> {
        return service.getApplication(id).toResponse()
    }

    @Operation(
        summary = "Получить код для получения заказа",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Код для получения заказа успешно получен",
                content = [
                    Content(
                        schema = Schema(implementation = PublicPickupCodeResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Заявка не найдена",
                content = [
                    Content(
                        schema = Schema(implementation = ErrorResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @GetMapping("/{id}/pickup-code")
    fun getPickupCode(
        @PathVariable id: String
    ): ResponseEntity<*> {
        val application = service.getApplication(id)

        return if (application == null) {
            null.toResponse()
        } else {
            ResponseEntity.ok(PublicPickupCodeResponse(application.pickupCode))
        }
    }

    private fun Application?.toResponse(): ResponseEntity<*> {
        return if (this == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse("Заявка не найдена"))
        } else {
            ResponseEntity.ok(mapper.toPublicApplicationResponse(this))
        }
    }
}
