package ru.tbank.itemsdeliverydemo.operatorback.client

import org.springframework.web.reactive.function.client.WebClient
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.PickupTaskRequest
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.PickupTaskResponse
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TakeTaskRequest
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TakeTaskResponse
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TaskResponse

class OperatorBackClientService(
    private val webClient: WebClient
) {

    fun takeTask(operatorId: String): TakeTaskResponse {
        return webClient.post()
            .uri("/api/v1/tasks/take")
            .bodyValue(TakeTaskRequest(operatorId))
            .retrieve()
            .bodyToMono(TakeTaskResponse::class.java)
            .block()!!
    }

    fun finishHandling(id: String): TaskResponse {
        return webClient.post()
            .uri("/api/v1/tasks/$id/complete-handling")
            .retrieve()
            .bodyToMono(TaskResponse::class.java)
            .block()!!
    }

    fun pickupTask(code: String): PickupTaskResponse {
        return webClient.post()
            .uri("/api/v1/tasks/pickup")
            .bodyValue(PickupTaskRequest(code))
            .retrieve()
            .bodyToMono(PickupTaskResponse::class.java)
            .block()!!
    }

    fun finishPickup(id: String): TaskResponse {
        return webClient.post()
            .uri("/api/v1/tasks/$id/finish")
            .retrieve()
            .bodyToMono(TaskResponse::class.java)
            .block()!!
    }
}
