package ru.tbank.itemsdeliverydemo.applicationsstorage.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring.kafka")
class KafkaServers {

    lateinit var bootstrapServers: String
}
