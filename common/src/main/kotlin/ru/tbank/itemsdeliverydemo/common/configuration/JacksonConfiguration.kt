package ru.tbank.itemsdeliverydemo.common.configuration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@AutoConfiguration
class JacksonConfiguration {

    @Bean
    @Primary
    fun objectMapper() = jacksonObjectMapper()
}
