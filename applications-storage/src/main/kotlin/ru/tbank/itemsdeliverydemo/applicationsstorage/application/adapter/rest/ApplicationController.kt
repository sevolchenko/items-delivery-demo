package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.ApplicationService
import ru.tbank.itemsdeliverydemo.applicationsstorage.mapper.ApplicationMapper
import java.net.http.HttpResponse
import java.util.UUID

@RestController
class ApplicationController
@RequestMapping("/api/v1/applications")
class ApplicationController(
    private val service: ApplicationService,
) {

}
