package ru.tbank.itemsdeliverydemo.common.autoconfiguration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.configuration.ApplicationsStorageClientConfiguration
import ru.tbank.itemsdeliverydemo.common.handling.WebClientFunctions.webClient
import ru.tbank.itemsdeliverydemo.common.streaming.KafkaProducer
import ru.tbank.itemsdeliverydemo.common.streaming.properties.KafkaServers
import ru.tbank.itemsdeliverydemo.itemscontroller.client.ItemsControllerClientService
import ru.tbank.itemsdeliverydemo.itemscontroller.client.configuration.ItemsControllerClientConfiguration
import ru.tbank.itemsdeliverydemo.itemskeeper.client.ItemsKeeperClientService
import ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration.ItemsKeeperClientConfiguration
import ru.tbank.itemsdeliverydemo.operatorback.client.OperatorBackClientService
import ru.tbank.itemsdeliverydemo.operatorback.client.configuration.OperatorBackClientConfiguration

@AutoConfiguration
@EnableConfigurationProperties(
    ApplicationsStorageClientConfiguration::class,
    ItemsControllerClientConfiguration::class,
    ItemsKeeperClientConfiguration::class,
    OperatorBackClientConfiguration::class,
    KafkaServers::class
)
class CommonPackageAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "service.applications-storage", name = ["enabled"], havingValue = "true")
    fun applicationsStorageClientService(
        config: ApplicationsStorageClientConfiguration
    ) = ApplicationsStorageClientService(webClient(config.host))

    @Bean
    @ConditionalOnProperty(prefix = "service.items-controller", name = ["enabled"], havingValue = "true")
    fun itemsControllerClientService(
        config: ItemsControllerClientConfiguration
    ) = ItemsControllerClientService(webClient(config.host))

    @Bean
    @ConditionalOnProperty(prefix = "service.items-keeper", name = ["enabled"], havingValue = "true")
    fun itemsKeeperClientService(
        config: ItemsKeeperClientConfiguration
    ) = ItemsKeeperClientService(webClient(config.host))

    @Bean
    @ConditionalOnProperty(prefix = "service.operator-back", name = ["enabled"], havingValue = "true")
    fun operatorBackClientService(
        config: OperatorBackClientConfiguration
    ) = OperatorBackClientService(webClient(config.host))

    @Bean
    @ConditionalOnBean(KafkaTemplate::class)
    fun kafkaProducer(
        kafkaTemplate: KafkaTemplate<String, String>,
        objectMapper: ObjectMapper
    ) = KafkaProducer(kafkaTemplate, objectMapper)
}
