package ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.configuration.TelegramClientServiceConfiguration
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.dto.SendMessageRequest

@Service
@ConditionalOnProperty(prefix = "service.telegram", name = ["enabled"], havingValue = "true")
class TelegramClientService(
    private val webClient: WebClient,
    private val conf: TelegramClientServiceConfiguration,
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
            .uri("${host()}/message")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
    }

    fun host() = conf.host + "/" + conf.apiKey
}
