package ru.tbank.itemsdeliverydemo.itemskeeper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(
    basePackages = [
        "ru.tbank.itemsdeliverydemo.common",
        "ru.tbank.itemsdeliverydemo.itemskeeper"
    ]
)
@SpringBootApplication
class ItemsKeeperApplication

fun main(args: Array<String>) {
    runApplication<ItemsKeeperApplication>(*args)
}
