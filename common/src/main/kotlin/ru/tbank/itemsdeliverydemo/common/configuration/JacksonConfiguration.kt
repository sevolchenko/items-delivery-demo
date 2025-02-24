package ru.tbank.itemsdeliverydemo.common.configuration

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AutoConfiguration
class JacksonConfiguration {

    @Bean
    @Primary
    fun objectMapper() = jacksonObjectMapper().apply {
        registerModule(
            JavaTimeModule().apply {
                val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
                addSerializer(
                    LocalDateTime::class.java, LocalDateTimeSerializer(formatter)
                )
                addDeserializer(
                    LocalDateTime::class.java, LocalDateTimeDeserializer(formatter)
                )
                disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            }
        )
    }
}
