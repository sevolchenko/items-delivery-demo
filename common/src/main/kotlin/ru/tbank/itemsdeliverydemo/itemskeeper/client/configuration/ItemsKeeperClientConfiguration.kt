package ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("service.items-keeper")
class ItemsKeeperClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String
}
