package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.ApplicationService
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.mapper.ApplicationMapper
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.ApplicationStatus
import ru.tbank.itemsdeliverydemo.common.handling.ErrorResponse

@RestController
@RequestMapping("/api/v1/applications")
class ApplicationController(
    private val service: ApplicationService,
    private val mapper: ApplicationMapper
) {

    @GetMapping("/{id}")
    fun getApplication(
        @PathVariable id: String
    ): ResponseEntity<*> {
        return service.getApplication(id).toResponse()
    }

    @PatchMapping("/{id}/status")
    fun setApplicationStatus(
        @PathVariable id: String,
        @RequestParam status: ApplicationStatus
    ): ResponseEntity<*> {
        return service.updateApplicationStatus(id, status).toResponse()
    }

    @PutMapping("/{id}/products/{productId}")
    fun updateProduct(
        @PathVariable id: String,
        @PathVariable productId: String,
        @RequestParam itemNumber: String,
    ): ResponseEntity<*> {
        return service.updateProduct(id, productId, itemNumber).toResponse()
    }

    private fun Application?.toResponse(): ResponseEntity<*> {
        return if (this == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse("No application found"))
        } else {
            ResponseEntity.ok(mapper.toApplicationResponse(this))
        }
    }
}
