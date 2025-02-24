package ru.tbank.itemsdeliverydemo.itemskeeper.cell

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.CellRepository
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.CellDimensionsRepository
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions
import ru.tbank.itemsdeliverydemo.itemskeeper.model.dto.CreateCellsRequest

@Service
class CellService(
    private val cellRepository: CellRepository,
    private val cellDimensionsRepository: CellDimensionsRepository
) {
    fun createCells(
        request: CreateCellsRequest
    ): List<String> {
        val cellDimensions = cellDimensionsRepository.findByLengthAndHeightAndWidth(
            request.length,
            request.height,
            request.width
        ).orElseGet {
            cellDimensionsRepository.save(
                CellDimensions(
                    length = request.length,
                    height = request.height,
                    width = request.width
                )
            )
        }

        val names = mutableListOf<String>()
        repeat(request.quantity) { index ->
            val savedCellName = cellRepository.save(
                Cell(
                    name = request.namePrefix + index,
                    cellDimensions = cellDimensions
                )
            ).name
            savedCellName.let { names.add(it!!) }
        }
        return names
    }
}
