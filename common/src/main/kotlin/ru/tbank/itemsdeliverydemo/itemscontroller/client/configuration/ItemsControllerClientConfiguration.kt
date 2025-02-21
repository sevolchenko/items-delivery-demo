package ru.tbank.itemsdeliverydemo.itemscontroller.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@ConfigurationProperties("service.items-controller")
class ItemsControllerClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String

    @Bean
    fun webClient(): WebClient = WebClient.create()
}
