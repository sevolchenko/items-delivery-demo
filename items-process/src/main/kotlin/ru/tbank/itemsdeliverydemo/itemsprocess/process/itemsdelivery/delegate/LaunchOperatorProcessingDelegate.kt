package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemsprocess.common.KotlinDelegate
import ru.tbank.itemsdeliverydemo.itemsprocess.common.get
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.APPLICATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component.OperatorProcessingLauncher

@Component
class LaunchOperatorProcessingDelegate(
    private val launcher: OperatorProcessingLauncher
): KotlinDelegate() {
    override fun doExecute(context: DelegateExecution) {
        launcher.launch(
            context[APPLICATION_ID]
        )
    }
}