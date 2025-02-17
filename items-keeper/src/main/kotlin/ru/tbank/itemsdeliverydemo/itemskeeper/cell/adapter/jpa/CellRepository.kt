package ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.tbank.itemsdeliverydemo.itemskeeper.cell.adapter.jpa.entity.Cell

@Repository
interface CellRepository : JpaRepository<Cell, Long>
