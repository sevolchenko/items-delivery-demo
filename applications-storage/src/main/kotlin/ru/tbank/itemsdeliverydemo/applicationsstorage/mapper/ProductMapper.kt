package ru.tbank.itemsdeliverydemo.applicationsstorage.mapper

import org.mapstruct.Mapper
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Product
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.ApplicationResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.rest.dto.ProductResponse

@Mapper
interface ProductMapper {

    fun toProductsResponse(entity: Product) : ProductResponse

}