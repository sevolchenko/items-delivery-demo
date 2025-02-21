package ru.tbank.itemsdeliverydemo.itemsprocess.configuration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat
import org.camunda.spin.spi.DataFormatConfigurator

open class JacksonDataFormatConfigurator : DataFormatConfigurator<JacksonJsonDataFormat> {

    override fun configure(dataFormat: JacksonJsonDataFormat) {
        dataFormat.objectMapper = jacksonObjectMapper()
    }

    override fun getDataFormatClass(): Class<JacksonJsonDataFormat> =
        JacksonJsonDataFormat::class.java
}
