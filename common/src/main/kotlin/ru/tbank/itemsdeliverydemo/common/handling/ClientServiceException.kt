package ru.tbank.itemsdeliverydemo.common.handling

class ClientServiceException(
    errorText: String? = null
) : RuntimeException(errorText)
