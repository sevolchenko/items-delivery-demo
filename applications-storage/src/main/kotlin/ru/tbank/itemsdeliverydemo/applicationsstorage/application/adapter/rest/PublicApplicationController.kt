package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.ApplicationService
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.CreateApplicationRequest
import ru.tbank.itemsdeliverydemo.applicationsstorage.mapper.ApplicationMapper

@RestController
@RequestMapping("/public/api/v1/applications")
class PublicApplicationController(
    private val service: ApplicationService,
    private val mapper: ApplicationMapper
) {

    @PostMapping
    fun createApplication(
        @RequestBody request: CreateApplicationRequest
    ): ResponseEntity<*> {
        return service.createApplication(request).toResponse()
    }

    private fun Application.toResponse(): ResponseEntity<*> {
        return ResponseEntity.ok(mapper.toPublicApplicationResponse(this))
    }

}