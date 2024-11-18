package ru.tbank.itemsdeliverydemo.itemscontroller.item

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.ItemRepository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    @Transactional
    fun reserveItem(
        type: String,
        color: String?
    ): Long? {
        val item = itemRepository.findFirstAvailableItem(type, color)

        return item?.let {
            it.status = ItemStatus.RESERVED
            itemRepository.save(it).id
        }
    }
}