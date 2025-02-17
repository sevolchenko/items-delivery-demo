package ru.tbank.itemsdeliverydemo.operatorinterface

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.operatorback.client.OperatorBackClientService
import ru.tbank.itemsdeliverydemo.operatorback.client.configuration.OperatorBackClientConfiguration

const val BACK_BASE_URL = "https://operator-back.items-delivery-demo.svc.cluster.local"

val client = OperatorBackClientService(
    webClient = WebClient.create(),
    conf = OperatorBackClientConfiguration().apply {
        host = BACK_BASE_URL
        enabled = true
    }
)
