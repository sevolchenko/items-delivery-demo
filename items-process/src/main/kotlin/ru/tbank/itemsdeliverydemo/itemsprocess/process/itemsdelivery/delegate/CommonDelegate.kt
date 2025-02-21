package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemsprocess.common.KotlinDelegate

@Component
class CommonDelegate : KotlinDelegate() {
    override fun doExecute(context: DelegateExecution) {
    }
}
