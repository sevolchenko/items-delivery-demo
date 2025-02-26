package ru.tbank.itemsdeliverydemo.common.client.external.telegram

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.notificationcenter.model.dto.SendMessageRequest

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
}
