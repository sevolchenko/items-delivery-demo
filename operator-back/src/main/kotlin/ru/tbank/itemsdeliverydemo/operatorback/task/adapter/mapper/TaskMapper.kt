package ru.tbank.itemsdeliverydemo.operatorback.task.adapter.mapper

import org.mapstruct.Mapper
import ru.tbank.itemsdeliverydemo.common.configuration.MapstructConfiguration
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TaskResponse
import ru.tbank.itemsdeliverydemo.operatorback.model.dto.TaskStatusUpdatedEvent
import ru.tbank.itemsdeliverydemo.operatorback.task.adapter.jpa.entity.Task

@Mapper(
    config = MapstructConfiguration::class
)
interface TaskMapper {

    fun toTaskResponse(entity: Task): TaskResponse

    fun toStatusUpdatedEvent(entity: Task): TaskStatusUpdatedEvent
}
