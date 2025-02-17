package ru.tbank.itemsdeliverydemo.operatorback.streaming

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.StartTaskHandlingEvent
import ru.tbank.itemsdeliverydemo.operatorback.task.TaskService

@Component
class StartTaskHandlingListener(
    private val objectMapper: ObjectMapper,
    private val service: TaskService
) {

    @KafkaListener(
        topics = ["\${spring.kafka.topics.start-task-handling}"],
        groupId = "\${spring.kafka.topics.start-task-handling}.\${spring.application.name}"
    )
    fun listen(message: String) {
        handle(objectMapper.readValue(message, StartTaskHandlingEvent::class.java))
    }

    fun handle(domain: StartTaskHandlingEvent) {
        service.createTask(
            domain.applicationId,
            domain.taskType
        )
    }
}
