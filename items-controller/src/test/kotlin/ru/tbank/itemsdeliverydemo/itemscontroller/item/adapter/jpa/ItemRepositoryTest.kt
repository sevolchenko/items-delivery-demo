package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import ru.tbank.itemsdeliverydemo.itemscontroller.IntegrationEnvironment
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ItemStatus
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

class ItemRepositoryTest : IntegrationEnvironment() {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    @Sql(
        statements = [
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', 'red', 'AVAILABLE')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', 'blue', 'RESERVED')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', NULL, 'AVAILABLE')"
        ]
    )
    fun `test findFirstAvailableItem with color`() {
        val result = itemRepository.findFirstAvailableItem(ProductType.PEN, "red")

        assertEquals(ProductType.PEN, result?.type)
        assertEquals("red", result?.color)
    }

    @Test
    @Sql(
        statements = [
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', NULL, 'AVAILABLE')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', 'blue', 'RESERVED')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'PEN', 'blue', 'RESERVED')"
        ]
    )
    fun `test findFirstAvailableItem without color`() {
        val result = itemRepository.findFirstAvailableItem(ProductType.PEN, null)

        assertEquals(ProductType.PEN, result?.type)
        assertEquals(null, result?.color)
        assertEquals(ItemStatus.AVAILABLE, result?.status)
    }

    @Test
    fun `test findFirstAvailableItem with non-existing item`() {
        val result = itemRepository.findFirstAvailableItem(ProductType.CARDHOLDER, "green")

        assertEquals(null, result)
    }
}
