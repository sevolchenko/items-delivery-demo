package ru.tbank.itemsdeliverydemo.itemsprocess.process.itemsdelivery.component

import mu.KLogging
import org.springframework.stereotype.Component
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.product
import ru.tbank.itemsdeliverydemo.itemscontroller.client.ItemsControllerClientService

@Component
class ProductReserver(
    private val itemsController: ItemsControllerClientService,
    private val storage: ApplicationsStorageClientService
) {

    fun reserveProduct(
        applicationId: String
    ): ProductReservationResult{
        val application = storage.getApplication(applicationId)

        val product = application.product()

        return try {
            ProductReservationResult(
                product.integrationId,
                itemsController.reserveItem(product.type).reservedItemId.toString()
            )
        } catch (e: Exception) {
            logger.info("Не зарезервировали продукт по заявке $applicationId. Exception: $e")
            ProductReservationResult(
                product.integrationId,
                null
            )
        }
    }

    data class ProductReservationResult(
        val productInterationId: String,
        val reservedItemId: String?
    )

    companion object : KLogging()
}
