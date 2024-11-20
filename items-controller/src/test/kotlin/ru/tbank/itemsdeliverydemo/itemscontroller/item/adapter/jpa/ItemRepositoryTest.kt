package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus

@DataJpaTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class ItemRepositoryTest {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    @Sql(statements = [
        "INSERT INTO items (id, type, color, status) VALUES (1, 'exampleType', 'red', 'AVAILABLE')",
        "INSERT INTO items (id, type, color, status) VALUES (2, 'exampleType', 'blue', 'RESERVED')",
        "INSERT INTO items (id, type, color, status) VALUES (3, 'exampleType', NULL, 'AVAILABLE')"
    ])
    fun `test findFirstAvailableItem with color`() {
        val result = itemRepository.findFirstAvailableItem("exampleType", "red")

        assertEquals("exampleType", result?.type)
        assertEquals("red", result?.color)
    }

    @Test
    @Sql(statements = [
        "INSERT INTO items (id, type, color, status) VALUES (1, 'exampleType', NULL, 'AVAILABLE')",
        "INSERT INTO items (id, type, color, status) VALUES (2, 'exampleType', 'blue', 'RESERVED')",
        "INSERT INTO items (id, type, color, status) VALUES (3, 'exampleType', 'blue', 'RESERVED')"
    ])
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
