package ru.tbank.itemsdeliverydemo.itemsprocess.streaming

import com.fasterxml.jackson.databind.ObjectMapper
import org.camunda.bpm.engine.RuntimeService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.applicationprocess.model.dto.EventType
import ru.tbank.itemsdeliverydemo.applicationprocess.model.dto.StartProcessingEvent
import ru.tbank.itemsdeliverydemo.itemsprocess.common.ITEMS_DELIVERY_PROCESS
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.APPLICATION_ID

@Component
class StartProcessingEventListener(
    private val objectMapper: ObjectMapper,
    private val runtimeService: RuntimeService
) {

    @KafkaListener(
        topics = ["\${spring.kafka.topics.start-processing}"],
        groupId = "\${spring.kafka.topics.start-processing}.\${spring.application.name}"
    )
    fun listen(message: String) {
        handle(objectMapper.readValue(message, StartProcessingEvent::class.java))
    }

    fun handle(domain: StartProcessingEvent) {
        when (domain.event) {
            EventType.START -> {
                runtimeService.startProcessInstanceByKey(
                    ITEMS_DELIVERY_PROCESS,
                    domain.applicationId,
                    mapOf(
                        APPLICATION_ID to domain.applicationId
                    )
                )
            }
        }
    }
}
