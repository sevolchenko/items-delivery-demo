package ru.tbank.itemsdeliverydemo.operatorback.mapper

import org.mapstruct.Mapper
import ru.tbank.itemsdeliverydemo.operatorback.configuration.MapstructConfiguration
import ru.tbank.itemsdeliverydemo.operatorback.streaming.TaskStatusUpdatedEvent
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.rest.dto.TaskResponse

@Mapper(
    config = MapstructConfiguration::class
)
interface TaskMapper {

    fun toTaskResponse(entity: Task): TaskResponse

    fun toStatusUpdatedEvent(entity: Task): TaskStatusUpdatedEvent
}
