package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.rest

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.CellService
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.model.dto.CreateCellRequest

@Tag(name = "cells")
@RestController
@RequestMapping("/api/v1/cells")
class CellContoller(
    private val cellService: CellService
) {
    @PostMapping("/create")
    fun createCell(
        @RequestBody request: CreateCellRequest
    ): ResponseEntity<*> {
        val createdCellId = cellService.createCell(request.cellName, request.cellDimensions)

        return ResponseEntity.ok().body(createdCellId)
    }
}
