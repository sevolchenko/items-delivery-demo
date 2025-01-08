package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.ApplicationService
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.ErrorResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.mapper.ApplicationMapper

@RestController
@RequestMapping("/api/v1/applications")
class ApplicationController(
    private val service: ApplicationService,
    private val mapper: ApplicationMapper
) {

    @GetMapping("/{id}")
    fun getApplication(
        @PathVariable id: String
    ) : ResponseEntity<*> {
        return service.getApplication(id)?.let { ResponseEntity.ok(mapper.toApplicationResponse(it)) }
            ?: ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse("No application found"))
    }

}
