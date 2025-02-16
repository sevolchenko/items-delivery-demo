package ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto

import ru.tbank.itemsdeliverydemo.applicationsstorage.application.model.ProductType

data class CreateApplicationRequest(
    val productType: ProductType,
    val customText: String? = null
)
