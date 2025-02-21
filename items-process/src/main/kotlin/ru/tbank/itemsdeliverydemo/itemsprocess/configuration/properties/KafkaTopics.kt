package ru.tbank.itemsdeliverydemo.itemsprocess.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("spring.kafka.topics")
class KafkaTopics {
    lateinit var taskStatusUpdated: String
    lateinit var startTaskHandling: String
    lateinit var notificationCenterInput: String
    lateinit var startProcessing: String
}
