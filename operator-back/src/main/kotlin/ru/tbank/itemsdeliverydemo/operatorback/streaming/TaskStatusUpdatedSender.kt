package ru.tbank.itemsdeliverydemo.operatorback.streaming

import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.operatorback.configuration.properties.KafkaTopics
import ru.tbank.itemsdeliverydemo.operatorback.mapper.TaskMapper
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import ru.tbank.itemsdeliverydemo.operatorback.task.model.TaskStatus

@Component
class TaskStatusUpdatedSender(
    private val kafkaProducer: KafkaProducer,
    private val topics: KafkaTopics,
    private val mapper: TaskMapper
) {

    fun sendStatusUpdated(
        task: Task
    ) {
        kafkaProducer.send(
            topics.taskStatusUpdated,
            mapper.toStatusUpdatedEvent(task)
        )
    }
}

data class TaskStatusUpdatedEvent(
    val taskId: String,
    val applicationId: String,
    val status: TaskStatus,
    val pickupCode: String? = null
)
