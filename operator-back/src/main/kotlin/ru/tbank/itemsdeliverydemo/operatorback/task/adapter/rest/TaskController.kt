package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.itemsdeliverydemo.operatorback.common.ErrorResponse
import ru.tbank.itemsdeliverydemo.operatorback.mapper.TaskMapper
import ru.tbank.itemsdeliverydemo.operatorback.task.TaskService
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(
    private val service: TaskService,
    private val mapper: TaskMapper
) {

    @GetMapping("/{id}")
    fun getTask(
        @PathVariable id: String
    ): ResponseEntity<*> {
        return service.getTask(id).toResponse()
    }

    private fun Task?.toResponse(): ResponseEntity<*> {
        return if (this == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse("No task found"))
        } else {
            ResponseEntity.ok(mapper.toTaskResponse(this))
        }
    }
}
