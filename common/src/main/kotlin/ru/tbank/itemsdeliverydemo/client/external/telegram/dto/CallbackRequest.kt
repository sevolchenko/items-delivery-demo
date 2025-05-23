package ru.tbank.itemsdeliverydemo.client.external.telegram.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CallbackRequest(
    @JsonProperty("client_id")
    val clientId: Long,
    val message: String
)
