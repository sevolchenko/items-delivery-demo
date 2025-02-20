package ru.tbank.itemsdeliverydemo.notificationcenter.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring.kafka.topics")
class KafkaTopics {
    lateinit var notificationCenterInput: String
}
