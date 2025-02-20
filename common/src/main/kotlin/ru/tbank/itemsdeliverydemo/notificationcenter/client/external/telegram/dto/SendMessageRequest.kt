package ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMessageRequest(
    @JsonProperty("client_id")
    val clientId: Long,
    val message: String
)
