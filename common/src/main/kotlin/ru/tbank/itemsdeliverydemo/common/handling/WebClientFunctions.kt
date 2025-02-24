package ru.tbank.itemsdeliverydemo.common.handling

import mu.KLogging
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeFilterFunction.ofRequestProcessor
import org.springframework.web.reactive.function.client.ExchangeFilterFunction.ofResponseProcessor
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

object WebClientFunctions : KLogging() {

    fun webClient(host: String): WebClient = WebClient
        .builder()
        .baseUrl(host)
        .filter(logRequest())
        .filter(logResponse())
        .filter(errorHandlingFilter())
        .build()

    fun errorHandlingFilter(): ExchangeFilterFunction {
        return ofResponseProcessor { clientResponse ->
            if (clientResponse.statusCode().isError) {
                clientResponse.bodyToMono(ErrorResponse::class.java)
                    .flatMap { Mono.error(ClientServiceException(it.message)) }
            } else {
                Mono.just(clientResponse)
            }
        }
    }

    fun logRequest(): ExchangeFilterFunction {
        return ofRequestProcessor { clientRequest ->
            logger.info("Request: ${clientRequest.method()} ${clientRequest.url()} ${clientRequest.body()}")
            Mono.just(clientRequest)
        }
    }

    fun logResponse(): ExchangeFilterFunction {
        return ofResponseProcessor { clientResponse ->
            "Response: ${clientResponse.request().method} ${clientResponse.request().uri} " +
                "${clientResponse.statusCode()}"
            Mono.just(clientResponse)
        }
    }
}
