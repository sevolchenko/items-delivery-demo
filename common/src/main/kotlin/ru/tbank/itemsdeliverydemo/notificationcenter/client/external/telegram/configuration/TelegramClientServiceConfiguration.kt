package ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("service.telegram")
class TelegramClientServiceConfiguration {

    var enabled: Boolean = false
    lateinit var apiKey: String
    lateinit var host: String
}
