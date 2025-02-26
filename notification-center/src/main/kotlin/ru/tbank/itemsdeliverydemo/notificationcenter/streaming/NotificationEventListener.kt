package ru.tbank.itemsdeliverydemo.notificationcenter.streaming

import com.fasterxml.jackson.databind.ObjectMapper
import mu.KLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.common.client.external.telegram.TelegramClientService
import ru.tbank.itemsdeliverydemo.common.client.external.telegram.dto.NotificationEvent

@Component
class NotificationEventListener(
    private val objectMapper: ObjectMapper,
    private val telegram: TelegramClientService
) {

    @KafkaListener(
        topics = ["\${spring.kafka.topics.notification-center-input}"],
        groupId = "\${spring.kafka.topics.notification-center-input}.\${spring.application.name}"
    )
    fun listen(message: String) {
        handle(objectMapper.readValue(message, NotificationEvent::class.java))
    }

    fun handle(domain: NotificationEvent) {
        logger.info("Notification event received: $domain")

        telegram.sendMessage(
            domain.clientId,
            domain.message
        )
    }

    companion object : KLogging()
}
