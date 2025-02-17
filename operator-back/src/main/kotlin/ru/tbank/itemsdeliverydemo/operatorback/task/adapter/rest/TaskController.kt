package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.common.ErrorResponse
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.PickupTaskRequest
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TakeTaskRequest
import ru.tbank.itemsdeliverydemo.operatorback.task.TaskService
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.mapper.TaskMapper

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(
    private val service: TaskService,
    private val mapper: TaskMapper
) {

    @PostMapping("/take")
    fun takeTask(
        @RequestBody body: TakeTaskRequest
    ): ResponseEntity<*> {
        return service.takeTask(body).toResponse("No pending tasks found")
    }

    @PostMapping("/{id}/complete-handling")
    fun finishHandling(
        @PathVariable id: String
    ): ResponseEntity<*> {
        return service.finishHandling(id).toResponse { mapper.toTaskResponse(it) }
    }

    @PostMapping("/pickup")
    fun pickupTask(
        @RequestBody body: PickupTaskRequest
    ): ResponseEntity<*> {
        return service.pickupTask(body.pickupCode).toResponse("Wrong code")
    }

    @PostMapping("/{id}/finish")
    fun finishPickup(
        @PathVariable id: String
    ): ResponseEntity<*> {
        return service.finishPickup(id).toResponse { mapper.toTaskResponse(it) }
    }

    private fun <T : Any> T?.toResponse(
        errorMsg: String = "No task found",
        mapping: (T) -> Any = { it }
    ): ResponseEntity<*> {
        return if (this == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(errorMsg))
        } else {
            ResponseEntity.ok(mapping(this))
        }
    }
}
