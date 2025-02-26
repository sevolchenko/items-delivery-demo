package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell
import java.util.Optional

@Repository
interface CellRepository : JpaRepository<Cell, String> {

    fun findAllByIdNotIn(ids: List<String>): List<Cell>

    fun findByName(name: String): Optional<Cell>
}
