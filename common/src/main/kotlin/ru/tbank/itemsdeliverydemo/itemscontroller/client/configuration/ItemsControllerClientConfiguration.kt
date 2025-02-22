package ru.tbank.itemsdeliverydemo.itemscontroller.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("service.items-controller")
class ItemsControllerClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String
}
