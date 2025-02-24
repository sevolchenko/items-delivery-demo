package ru.tbank.itemsdeliverydemo.applicationsstorage.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("service.applications-storage")
class ApplicationsStorageClientConfiguration {

    var enabled: Boolean = false
    lateinit var host: String
}
