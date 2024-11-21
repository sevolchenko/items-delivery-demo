package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import ru.tbank.itemsdeliverydemo.itemscontroller.IntegrationEnvironment
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus

class ItemRepositoryTest : IntegrationEnvironment() {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    @Sql(
        statements = [
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', 'red', 'AVAILABLE')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', 'blue', 'RESERVED')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', NULL, 'AVAILABLE')"
        ]
    )
    fun `test findFirstAvailableItem with color`() {
        val result = itemRepository.findFirstAvailableItem("exampleType", "red")

        assertEquals("exampleType", result?.type)
        assertEquals("red", result?.color)
    }

    @Test
    @Sql(
        statements = [
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', NULL, 'AVAILABLE')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', 'blue', 'RESERVED')",
            "INSERT INTO item (id, type, color, status) VALUES (gen_random_uuid(), 'exampleType', 'blue', 'RESERVED')"
        ]
    )
    fun `test findFirstAvailableItem without color`() {
        val result = itemRepository.findFirstAvailableItem("exampleType", null)

        assertEquals("exampleType", result?.type)
        assertEquals(null, result?.color)
        assertEquals(ItemStatus.AVAILABLE, result?.status)
    }

    @Test
    fun `test findFirstAvailableItem with non-existing item`() {
        val result = itemRepository.findFirstAvailableItem("nonExistingType", "green")

        assertEquals(null, result)
    }
}
