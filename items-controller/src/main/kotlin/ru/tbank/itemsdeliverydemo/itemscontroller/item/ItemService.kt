package ru.tbank.itemsdeliverydemo.itemscontroller.item

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.ItemRepository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity.Item
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

    fun createItems(
        type: String,
        color: String?,
        quantity: Int
    ): List<UUID> {
        val uuidList = mutableListOf<UUID>()
        repeat(quantity){
            itemRepository.save(Item(type = type, color = color)).id?.let { it1 -> uuidList.add(it1) }
        }
        return uuidList;
    }
}
