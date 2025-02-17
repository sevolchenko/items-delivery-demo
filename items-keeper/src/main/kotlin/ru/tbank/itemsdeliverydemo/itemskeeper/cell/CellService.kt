package ru.tbank.itemsdeliverydemo.itemskeeper.cell

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.CellRepository
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions
import java.util.UUID

@Service
class CellService (
    private val cellRepository: CellRepository
) {
    fun createCell (
        name: String?,
        dimensions: CellDimensions
    ) : UUID? {
        val cell = cellRepository.save(Cell(name = name, cellDimensions = dimensions))

        return cell.id
    }

}