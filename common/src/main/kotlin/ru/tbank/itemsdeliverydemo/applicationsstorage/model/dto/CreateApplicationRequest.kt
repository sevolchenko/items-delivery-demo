package ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto

import org.hibernate.validator.constraints.Length
import ru.tbank.itemsdeliverydemo.itemscontroller.model.ProductType

data class CreateApplicationRequest(
    val productType: ProductType,

    @Length(max = 20)
    val customText: String? = null
)
