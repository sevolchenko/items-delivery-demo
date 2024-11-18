package ru.tbank.itemsdeliverydemo.itemscontroller.item

import com.nhaarman.mockitokotlin2.any
import io.github.glytching.junit.extension.random.RandomBeansExtension
import org.junit.jupiter.api.extension.ExtendWith
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.github.glytching.junit.extension.random.Random
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.ItemRepository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity.Item
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus

@ExtendWith(RandomBeansExtension::class)
class ItemServiceTest {

    private val repository = mock<ItemRepository>()

    private val service = ItemService(repository)

    @Test
    fun `where item not found then return null`(
        @Random type: String,
        @Random color: String,
    ) {
        whenever(repository.findFirstAvailableItem(type, color))
            .thenReturn(null)

        val result = service.reserveItem(type, color)

        assertThat(result).isNull()
    }

    @Test
    fun `where item found then return it's id and set status to reserved`(
        @Random id: Long,
        @Random type: String,
        @Random color: String,
    ) {
        val item = Item(id = id, type = type, color = color)
        whenever(repository.findFirstAvailableItem(type, color))
            .thenReturn(item)

        val result = service.reserveItem(type, color)

        assertThat(result).isEqualTo(id)
        with (item) {
            assertThat(status).isEqualTo(ItemStatus.RESERVED)
            assertThat(updatedAt).isNotNull()
            assertThat(updatedAt).isAfter(createdAt)
        }
    }

}
