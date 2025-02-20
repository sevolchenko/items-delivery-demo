package ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions
import java.util.Optional

@Repository
interface CellDimensionsRepository : JpaRepository<CellDimensions, Long> {

    fun findByLengthAndHeightAndWidth(length: Double, height: Double, width: Double): Optional<CellDimensions>
}
