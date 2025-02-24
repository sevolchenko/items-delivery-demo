package ru.tbank.itemsdeliverydemo.operatorinterface

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.operatorback.client.OperatorBackClientService

const val BACK_BASE_URL = "http://localhost/operator-back/"

val client = OperatorBackClientService(
    WebClient.create(BACK_BASE_URL),
)
