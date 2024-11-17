package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.itemscontroller.item.ItemService
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.rest.dto.ReserveItemResponse

@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val itemService: ItemService
) {

    @PostMapping("/reserve")
    fun reserveItem(
        @RequestParam(required = false) type: String?,
        @RequestParam(required = false) color: String?
    ): ResponseEntity<*> {
        val reservedItemId = itemService.reserveItem(type, color)
            ?: return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body("No available item found")

        return ResponseEntity.ok().body(ReserveItemResponse(reservedItemId))
    }
}