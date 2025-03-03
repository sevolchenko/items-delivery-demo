package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.itemsprocess.common.KotlinDelegate
import ru.tbank.itemsdeliverydemo.itemsprocess.common.get
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.APPLICATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.PRODUCT_INTEGRATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.RESERVED_ITEM_ID

@Component
class SaveReservedProductDelegate(
    private val storage: ApplicationsStorageClientService
) : KotlinDelegate() {
    override fun doExecute(context: DelegateExecution) {
        storage.updateProduct(
            context[APPLICATION_ID],
            context[PRODUCT_INTEGRATION_ID],
            context[RESERVED_ITEM_ID]
        )
    }
}
