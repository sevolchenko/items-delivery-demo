package ru.tbank.itemsdeliverydemo.itemscontroller.item

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.ItemRepository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus
import java.time.LocalDateTime
import java.util.UUID

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    @Transactional
    fun reserveItem(
        type: String,
        color: String?
    ): UUID? {
        val item = itemRepository.findFirstAvailableItem(type, color) ?: return null

        return item.apply {
            status = ItemStatus.RESERVED
            updatedAt = LocalDateTime.now()
        }.id
    }
}
