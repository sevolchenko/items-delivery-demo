package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component

import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.common.streaming.KafkaProducer
import ru.tbank.itemsdeliverydemo.itemsprocess.configuration.properties.KafkaTopics
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskType
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.StartTaskHandlingEvent

@Component
class OperatorProcessingLauncher(
    private val kafkaProducer: KafkaProducer,
    private val topics: KafkaTopics
) {

    fun launch(applicationId: String) {
        kafkaProducer.send(
            topics.startTaskHandling,
            StartTaskHandlingEvent(
                applicationId,
                TaskType.RESERVE_ITEM
            )
        )
    }

}