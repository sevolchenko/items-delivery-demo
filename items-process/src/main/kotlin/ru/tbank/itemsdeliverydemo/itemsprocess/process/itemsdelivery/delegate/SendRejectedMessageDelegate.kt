package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemsprocess.common.KotlinDelegate
import ru.tbank.itemsdeliverydemo.itemsprocess.common.get
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.APPLICATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component.NotificationSender

@Component
class SendRejectedMessageDelegate(
    private val notificationSender: NotificationSender
) : KotlinDelegate() {
    override fun doExecute(context: DelegateExecution) {
        notificationSender.sendApplicationCancelled(
            context[APPLICATION_ID]
        )
    }
}
