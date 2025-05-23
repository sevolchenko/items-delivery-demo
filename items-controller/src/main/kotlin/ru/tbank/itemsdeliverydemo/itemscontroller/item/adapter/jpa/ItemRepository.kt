package ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.itemscontroller.item.adapter.jpa.entity.Item
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

@Repository
interface ItemRepository : JpaRepository<Item, String> {

    @Query(
        """
            SELECT i
            FROM Item i
            WHERE i.status = 'AVAILABLE'
                AND i.type = :type
                AND (:color IS NULL OR i.color = :color)
            ORDER BY i.createdAt
            LIMIT 1
        """
    )
    fun findFirstAvailableItem(@Param("type") type: ProductType, @Param("color") color: String?): Item?
}
