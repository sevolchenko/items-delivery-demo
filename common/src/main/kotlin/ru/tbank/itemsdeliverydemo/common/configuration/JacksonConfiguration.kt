package ru.tbank.itemsdeliverydemo.common.configuration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class JacksonConfiguration {

    @Bean
    @Primary
    fun objectMapper() = jacksonObjectMapper()
}
