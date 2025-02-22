package ru.tbank.itemsdeliverydemo.common.autoconfiguration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.ApplicationsStorageClientService
import ru.tbank.itemsdeliverydemo.applicationsstorage.client.configuration.ApplicationsStorageClientConfiguration
import ru.tbank.itemsdeliverydemo.common.streaming.KafkaProducer
import ru.tbank.itemsdeliverydemo.common.streaming.properties.KafkaServers
import ru.tbank.itemsdeliverydemo.itemscontroller.client.ItemsControllerClientService
import ru.tbank.itemsdeliverydemo.itemscontroller.client.configuration.ItemsControllerClientConfiguration
import ru.tbank.itemsdeliverydemo.itemskeeper.client.ItemsKeeperClientService
import ru.tbank.itemsdeliverydemo.itemskeeper.client.configuration.ItemsKeeperClientConfiguration
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.TelegramClientService
import ru.tbank.itemsdeliverydemo.notificationcenter.client.external.telegram.configuration.TelegramClientServiceConfiguration
import ru.tbank.itemsdeliverydemo.operatorback.client.OperatorBackClientService
import ru.tbank.itemsdeliverydemo.operatorback.client.configuration.OperatorBackClientConfiguration

@AutoConfiguration
@EnableConfigurationProperties(
    ApplicationsStorageClientConfiguration::class,
    ItemsControllerClientConfiguration::class,
    ItemsKeeperClientConfiguration::class,
    OperatorBackClientConfiguration::class,
    TelegramClientServiceConfiguration::class,
    KafkaServers::class
)
class CommonPackageAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingBean(WebClient::class)
    fun defaultWebClient(): WebClient = WebClient.create()

    @Bean
    @ConditionalOnProperty(prefix = "service.applications-storage", name = ["enabled"], havingValue = "true")
    fun applicationsStorageClientService(
        config: ApplicationsStorageClientConfiguration,
        webClient: WebClient
    ) = ApplicationsStorageClientService(webClient, config)

    @Bean
    @ConditionalOnProperty(prefix = "service.items-controller", name = ["enabled"], havingValue = "true")
    fun itemsControllerClientService(
        config: ItemsControllerClientConfiguration,
        webClient: WebClient
    ) = ItemsControllerClientService(webClient, config)

    @Bean
    @ConditionalOnProperty(prefix = "service.items-keeper", name = ["enabled"], havingValue = "true")
    fun itemsKeeperClientService(
        config: ItemsKeeperClientConfiguration,
        webClient: WebClient
    ) = ItemsKeeperClientService(webClient, config)

    @Bean
    @ConditionalOnProperty(prefix = "service.operator-back", name = ["enabled"], havingValue = "true")
    fun operatorBackClientService(
        config: OperatorBackClientConfiguration,
        webClient: WebClient
    ) = OperatorBackClientService(webClient, config)

    @Bean
    @ConditionalOnProperty(prefix = "service.telegram", name = ["enabled"], havingValue = "true")
    fun telegramClientService(
        config: TelegramClientServiceConfiguration,
        webClient: WebClient
    ) = TelegramClientService(webClient, config)

    @Bean
    @ConditionalOnBean(KafkaTemplate::class)
    fun kafkaProducer(
        kafkaTemplate: KafkaTemplate<String, String>,
        objectMapper: ObjectMapper
    ) = KafkaProducer(kafkaTemplate, objectMapper)
}
