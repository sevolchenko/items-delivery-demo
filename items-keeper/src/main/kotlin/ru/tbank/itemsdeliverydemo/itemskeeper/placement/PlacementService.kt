package ru.tbank.itemsdeliverydemo.itemskeeper.placement

import org.springframework.stereotype.Service
import ru.tbank.itemsdeliverydemo.itemscontroller.client.ItemsControllerClientService
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import ru.tbank.itemsdeliverydemo.itemscontroller.model.Size
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.CellRepository
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import ru.tbank.itemsdeliverydemo.itemskeeper.celldimensions.adapter.jpa.entity.CellDimensions
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa.PlacementRepository
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.adapter.jpa.entity.Placement
import ru.tbank.itemsdeliverydemo.itemskeeper.placement.model.PlacementStatus
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class PlacementService(
    private val placementRepository: PlacementRepository,
    private val cellRepository: CellRepository,
    private val itemsController: ItemsControllerClientService
) {

    fun placeProduct(
        productId: String
    ): Placement {
        val productType = itemsController.findItemById(productId).type
        val cell = findFreeCell(productType)

        return placementRepository.save(
            Placement(productId = productId, cell = cell)
        )
    }

    fun findFreeCell(productType: ProductType): Cell {
        val busyCells = placementRepository.findAllByStatus(PlacementStatus.BUSY).map { it.cell!! }
        val freeCells = if (busyCells.isEmpty()) {
            cellRepository.findAll()
        } else {
            cellRepository.findAllByIdNotIn(busyCells.map { it.id })
        }

        return freeCells.filter {
            canFit(it.cellDimensions!!, productType.size)
        }.minByOrNull { square(it.cellDimensions!!) }
            ?: error("Свободных ячеек для такого продукта нет")
    }

    private fun square(dim: CellDimensions): Double {
        return dim.length * dim.width
    }

    private fun canFit(dim: CellDimensions, product: Size): Boolean {
        return (product.length <= dim.length && product.width <= dim.width) ||
            (product.length <= dim.width && product.width <= dim.length)
    }

    fun finishPlacement(
        placementId: String
    ): Placement? {
        return placementRepository.findById(placementId).getOrNull()?.apply {
            status = PlacementStatus.COMPLETED
            updatedAt = LocalDateTime.now()
        }?.also {
            placementRepository.save(it)
        }
    }
}
