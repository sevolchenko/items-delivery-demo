package ru.tbank.itemsdeliverydemo.operatorback.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("service.operator-back")
class OperatorBackClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String
}
