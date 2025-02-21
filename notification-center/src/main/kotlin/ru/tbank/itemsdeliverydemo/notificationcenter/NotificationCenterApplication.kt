package ru.tbank.itemsdeliverydemo.notificationcenter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(
    basePackages = [
        "ru.tbank.itemsdeliverydemo.common",
        "ru.tbank.itemsdeliverydemo.notificationcenter"
    ]
)
@SpringBootApplication
class NotificationCenterApplication

fun main(args: Array<String>) {
    runApplication<NotificationCenterApplication>(*args)
}
