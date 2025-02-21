package ru.tbank.itemsdeliverydemo.itemscontroller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = [
        "ru.tbank.itemsdeliverydemo.common",
        "ru.tbank.itemsdeliverydemo.itemscontroller"
    ]
)
class ItemsControllerApplication

fun main(args: Array<String>) {
    runApplication<ItemsControllerApplication>(*args)
}
