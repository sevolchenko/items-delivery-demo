package ru.tbank.itemsdeliverydemo.common.streaming

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
@ConditionalOnBean(KafkaTemplate::class)
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    fun <T> send(topic: String, message: T) {
        val messageString = objectMapper.writeValueAsString(message)

        kafkaTemplate.send(topic, messageString)
    }
}
