package ru.tbank.itemsdeliverydemo.applicationsstorage.component

import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.applicationsstorage.configuration.properties.KafkaTopics

@Component
class ProcessingStarter(
    private val kafkaProducer: KafkaProducer,
    private val topics: KafkaTopics
) {

    fun startProcessing(
        applicationId: String
    ) {
        kafkaProducer.send(
            topics.startProcessing,
            StartProcessingEvent(
                event = "start",
                applicationId = applicationId
            )
        )
    }

}

data class StartProcessingEvent(
    val event: String,
    val applicationId: String
)