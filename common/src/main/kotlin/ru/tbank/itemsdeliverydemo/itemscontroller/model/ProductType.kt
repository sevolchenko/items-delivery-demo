package ru.tbank.itemsdeliverydemo.itemscontroller.model

enum class ProductType(
    val ruName: String,
    val size: Size
) {
    NOTEBOOK("Блокнот", Size(10.0, 15.0, 20.0)),
    PEN("Ручка", Size(1.0, 2.0, 3.0)),
    STICKER("Стикер", Size(1.0, 2.0, 3.0)),
    CARDHOLDER("Кардхолдер", Size(10.0, 15.0, 20.0))
}

data class Size(
    val width: Double,
    val height: Double,
    val depth: Double
)
