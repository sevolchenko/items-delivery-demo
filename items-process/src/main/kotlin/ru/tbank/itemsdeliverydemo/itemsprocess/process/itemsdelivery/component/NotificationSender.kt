package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component

import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.common.streaming.KafkaProducer
import ru.tbank.itemsdeliverydemo.itemsprocess.configuration.properties.KafkaTopics
import ru.tbank.itemsdeliverydemo.notificationcenter.model.dto.NotificationEvent

@Component
class NotificationSender(
    private val kafkaProducer: KafkaProducer,
    private val topics: KafkaTopics,
    private val storage: ApplicationsStorageClientService
) {

    fun sendApplicationReadyToReceive(
        applicationId: String,
        pickupCode: String
    ) {
        sendMessage(
            getClientId(applicationId),
            "Мерч готов к получению! Назови оператору код: $pickupCode. У тебя есть 10 минут, чтобы забрать заказ"
        )
    }

    fun sendApplicationCancelled(
        applicationId: String
    ) {
        sendMessage(
            getClientId(applicationId),
            "К сожалению, на складе не осталось достаточно такого мерча. Попробуй другой тип :)"
        )
    }

    fun sendApplicationNotUspel(
        applicationId: String
    ) {
        sendMessage(
            getClientId(applicationId),
            "Ты не получил товар за 10 минут, мы отменили твой заказ"
        )
    }

    private fun sendMessage(clientId: Long, message: String) {
        kafkaProducer.send(
            topics.notificationCenterInput,
            NotificationEvent(
                clientId,
                message
            )
        )
    }

    private fun getClientId(
        applicationId: String
    ) = storage.getApplication(applicationId).clientId
}
