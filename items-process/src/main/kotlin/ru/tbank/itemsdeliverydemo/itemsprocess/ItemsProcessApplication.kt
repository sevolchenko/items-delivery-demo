package ru.tbank.itemsdeliverydemo.itemsprocess

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableProcessApplication
@ComponentScan(
    basePackages = [
        "ru.tbank.itemsdeliverydemo.common",
        "ru.tbank.itemsdeliverydemo.itemsprocess"
    ]
)
class ItemsProcessApplication

fun main(args: Array<String>) {
    runApplication<ItemsProcessApplication>(*args)
}
