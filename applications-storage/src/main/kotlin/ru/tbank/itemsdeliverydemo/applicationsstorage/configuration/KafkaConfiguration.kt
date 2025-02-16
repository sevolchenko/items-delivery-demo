package ru.tbank.itemsdeliverydemo.applicationsstorage.configuration

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import ru.tbank.itemsdeliverydemo.applicationsstorage.configuration.properties.KafkaServers

@Configuration
class KafkaConfiguration {

    @Bean
    fun producerFactory(
        kafkaServers: KafkaServers
    ): ProducerFactory<String, String> {
        val configProps = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaServers.bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )

        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(
        producerFactory: ProducerFactory<String, String>
    ): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory)
    }
}
