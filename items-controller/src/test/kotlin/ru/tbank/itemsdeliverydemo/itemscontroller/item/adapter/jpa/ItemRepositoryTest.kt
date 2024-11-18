package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql
import ru.tbank.itemsdeliverydemo.itemscontroller.item.model.ItemStatus

@DataJpaTest
@AutoConfigureTestDatabase
class ItemRepositoryTest {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    @Sql(statements = [
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', 'red', 'AVAILABLE', CURRENT_TIMESTAMP)",
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', 'blue', 'RESERVED', CURRENT_TIMESTAMP)",
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', NULL, 'AVAILABLE', CURRENT_TIMESTAMP)"
    ])
    fun `test findFirstAvailableItem with color`() {
        val result = itemRepository.findFirstAvailableItem("exampleType", "red")

        assertEquals("exampleType", result?.type)
        assertEquals("red", result?.color)
    }

    @Test
    @Sql(statements = [
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', NULL, 'AVAILABLE', CURRENT_TIMESTAMP)",
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', 'blue', 'RESERVED', CURRENT_TIMESTAMP)",
        "INSERT INTO items (type, color, status, created_at) VALUES ('exampleType', 'blue', 'RESERVED', CURRENT_TIMESTAMP)"
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
