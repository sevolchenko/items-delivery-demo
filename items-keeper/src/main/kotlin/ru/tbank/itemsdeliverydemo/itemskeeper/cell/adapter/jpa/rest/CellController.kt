package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.rest

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.CellService
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.CreateCellsRequest

@Tag(name = "cells")
@RestController
@RequestMapping("/api/v1/cells")
class CellController(
    private val cellService: CellService
) {
    @PostMapping("/create")
    fun createCells(
        @RequestBody request: CreateCellsRequest
    ): ResponseEntity<*> {
        val createdCellsNames = cellService.createCells(request)

        return ResponseEntity.ok().body(createdCellsNames)
    }
}
