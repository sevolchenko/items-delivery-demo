package ru.tbank.itemsdeliverydemo.applicationsstorage.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@ConfigurationProperties("service.applications-storage")
class ApplicationsStorageClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String

    @Bean
    fun webClient(): WebClient = WebClient.create()
}
