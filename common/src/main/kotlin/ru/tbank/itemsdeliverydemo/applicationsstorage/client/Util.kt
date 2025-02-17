package ru.tbank.itemsdeliverydemo.applicationsstorage.client

import ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto.ApplicationResponse

fun ApplicationResponse.product() = products.first()
