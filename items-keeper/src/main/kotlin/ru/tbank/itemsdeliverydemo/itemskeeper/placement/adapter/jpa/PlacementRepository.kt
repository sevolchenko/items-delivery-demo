package ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa.entity.Placement
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.model.PlacementStatus

@Repository
interface PlacementRepository : JpaRepository<Placement, String> {

    fun findAllByStatus(status: PlacementStatus): List<Placement>
}
