package ru.tbank.itemsdeliverydemo.operatorinterface

import ru.tbank.itemsdeliverydemo.common.handling.WebClientFunctions.webClient
import ru.tbank.itemsdeliverydemo.operatorback.client.OperatorBackClientService

const val BACK_BASE_URL = "http://localhost/operator-back/"

val client = OperatorBackClientService(
    webClient(BACK_BASE_URL),
)
