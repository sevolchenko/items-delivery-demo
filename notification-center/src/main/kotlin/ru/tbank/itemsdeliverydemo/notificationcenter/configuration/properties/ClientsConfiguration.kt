package ru.tbank.itemsdeliverydemo.notificationcenter.configuration.properties

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.TelegramClientService
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.configuration.TelegramClientServiceConfiguration

@Configuration
class ClientsConfiguration {

    @Bean
    fun telegramClientService(
        config: TelegramClientServiceConfiguration
    ) = TelegramClientService(
        WebClient.create(config.host + "/" + config.apiKey)
    )
}
