package ru.tbank.itemsdeliverydemo.itemscontroller.model

enum class ProductType(
    val ruName: String,
    val size: Size
) {
    NOTEBOOK("Блокнот", Size(150.0, 3.0, 200.0)),
    PEN("Ручка", Size(1.0, 1.0, 13.0)),
    STICKER("Стикерпак", Size(5.0, 1.0, 5.0)),
    CARDHOLDER("Кардхолдер", Size(11.0, 1.0, 7.0)),
    PACK("Пак", Size(150.0, 3.0, 200.0))
}

data class Size(
    val width: Double,
    val height: Double,
    val length: Double
)
