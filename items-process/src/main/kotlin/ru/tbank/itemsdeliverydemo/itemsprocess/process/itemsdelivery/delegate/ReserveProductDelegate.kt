package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.itemsprocess.common.KotlinDelegate
import ru.tbank.itemsdeliverydemo.itemsprocess.common.get
import ru.tbank.itemsdeliverydemo.itemsprocess.common.set
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.APPLICATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.PRODUCT_INTEGRATION_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.common.RESERVED_ITEM_ID
import ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component.ProductReserver

@Component
class ReserveProductDelegate(
    private val productReserver: ProductReserver
) : KotlinDelegate() {
    override fun doExecute(context: DelegateExecution) {
        val applicationId = context[APPLICATION_ID]

        val (integrationId, itemId) = productReserver.reserveProduct(applicationId)

        context[PRODUCT_INTEGRATION_ID] = integrationId
        context[RESERVED_ITEM_ID] = itemId
    }
}
