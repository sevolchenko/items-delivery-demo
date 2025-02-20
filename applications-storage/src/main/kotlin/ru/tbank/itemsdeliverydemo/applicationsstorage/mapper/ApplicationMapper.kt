package ru.tbank.itemsdeliverydemo.applicationsstorage.mapper

import org.mapstruct.Mapper
import ru.tbank.itemsdeliverydemo.applicationsstorage.application.adapter.jpa.entity.Application
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto.ApplicationResponse
import ru.tbank.itemsdeliverydemo.applicationsstorage.model.dto.PublicApplicationResponse
import ru.tbank.itemsdeliverydemo.common.configuration.MapstructConfiguration

@Mapper(
    config = MapstructConfiguration::class,
    uses = [
        ProductMapper::class
    ]
)
interface ApplicationMapper {

    fun toApplicationResponse(entity: Application): ApplicationResponse

    fun toPublicApplicationResponse(entity: Application): PublicApplicationResponse
}
