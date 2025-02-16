package ru.tbank.itemsdeliverydemo.applicationsstorage.component

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaSender(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    fun <T> sendMessage(topic: String, message: T) {
        val messageString = objectMapper.writeValueAsString(message)

        kafkaTemplate.send(topic, messageString)
    }
}