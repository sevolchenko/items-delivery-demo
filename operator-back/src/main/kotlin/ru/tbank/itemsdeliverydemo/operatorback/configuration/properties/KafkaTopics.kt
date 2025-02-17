package ru.tbank.itemsdeliverydemo.operatorback.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring.kafka.topics")
class KafkaTopics {
    lateinit var taskStatusUpdated: String
}
