package ru.tbank.itemsdeliverydemo.itemscontroller.item

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.ItemRepository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity.Item
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ItemStatus
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import java.time.LocalDateTime
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    @Transactional
    fun reserveItem(
        type: ProductType,
        color: String?
    ): UUID? {
        val item = itemRepository.findFirstAvailableItem(type, color) ?: return null

        return item.apply {
            status = ItemStatus.RESERVED
            updatedAt = LocalDateTime.now()
        }.id
    }

    fun findItemByNumber(
        itemNumber: String
    ) = itemRepository.findById(itemNumber.toLong()).getOrNull()

    fun createItems(
        type: ProductType,
        color: String?,
        quantity: Int
    ): List<UUID> {
        val uuidList = mutableListOf<UUID>()
        repeat(quantity) {
            val savedItemId = itemRepository.save(Item(type = type, color = color)).id
            savedItemId?.let { id -> uuidList.add(id) }
        }
        return uuidList
    }
}
