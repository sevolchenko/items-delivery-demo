package ru.tbank.itemsdeliverydemo.operatorback.component

import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskType

@Component
class InstructionsBuilder {

    fun buildInstructionsFor(
        taskType: TaskType,
        productType: ProductType,
        customText: String?,
        cellId: String
    ): String {
        val instructions = StringBuilder()

        when (taskType) {
            TaskType.RESERVE_ITEM -> {
                instructions.appendLine("Возьми предмет \"${productType.ruName.uppercase()}\"")
                customText?.let {
                    instructions.appendLine("Наклей на предмет стикер с надписью \"$customText\"")
                }
                instructions.appendLine("Положи предмет в ячейку $cellId")
                instructions.appendLine("Нажми ENTER")
            }
        }

        return instructions.toString()
    }
}
