package ru.tbank.itemsdeliverydemo.client.external.telegram

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.client.external.telegram.dto.CallbackRequest
import ru.tbank.itemsdeliverydemo.client.external.telegram.dto.SendMessageRequest

class TelegramClientService(
    private val webClient: WebClient
) {

    fun sendMessage(
        clientId: Long,
        message: String
    ) {
        val request = SendMessageRequest(
            clientId,
            message
        )

        webClient.post()
            .uri("/message")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
    }

    fun sendCallback(
        clientId: Long,
        message: String
    ) {
        val request = CallbackRequest(
            clientId,
            message
        )

        webClient.post()
            .uri("/callback")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
    }
}
