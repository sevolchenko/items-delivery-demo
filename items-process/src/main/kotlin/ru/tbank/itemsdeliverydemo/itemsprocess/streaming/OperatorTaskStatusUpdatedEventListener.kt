package ru.tbank.itemsdeliverydemo.itemsprocess.streaming

import com.fasterxml.jackson.databind.ObjectMapper
import org.camunda.bpm.engine.RuntimeService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.PICKUP_CODE
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.WAIT_PICKUP_MESSAGE
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.WAIT_READY_TO_PICKUP_MESSAGE
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.WAIT_TASK_CREATION_MESSAGE
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.WAIT_TASK_HANDLING_MESSAGE
import ru.tbank.itemsdeliverydemo.operatorback.model.TaskStatus
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TaskStatusUpdatedEvent

@Component
class OperatorTaskStatusUpdatedEventListener(
    private val objectMapper: ObjectMapper,
    private val runtimeService: RuntimeService
) {

    @KafkaListener(
        topics = ["\${spring.kafka.topics.task-status-updated}"],
        groupId = "\${spring.kafka.topics.task-status-updated}.\${spring.application.name}"
    )
    fun listen(message: String) {
        handle(objectMapper.readValue(message, TaskStatusUpdatedEvent::class.java))
    }

    fun handle(domain: TaskStatusUpdatedEvent) {
        messageFromStatus(domain.status)?.let { message ->
            correlate(
                message,
                domain.applicationId,
                domain.pickupCode?.let {
                    mapOf(PICKUP_CODE to it)
                } ?: emptyMap()
            )
        }
    }

    private fun messageFromStatus(
        status: TaskStatus
    ) = when (status) {
        TaskStatus.WAITING_FOR_HANDLING -> WAIT_TASK_CREATION_MESSAGE
        TaskStatus.HANDLING -> WAIT_TASK_HANDLING_MESSAGE
        TaskStatus.WAITING_FOR_PICKUP -> WAIT_READY_TO_PICKUP_MESSAGE
        TaskStatus.FINISHED -> WAIT_PICKUP_MESSAGE
        TaskStatus.CANCELLED -> null
    }

    private fun correlate(
        message: String,
        applicationId: String,
        vars: Map<String, Any?>
    ) {
        runtimeService.createMessageCorrelation(message).apply {
            processInstanceBusinessKey(applicationId)
            vars.forEach(this::setVariable)
        }.correlate()
    }
}
