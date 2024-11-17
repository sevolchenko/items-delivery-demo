package ru.tbank.itemsdeliverydemo.itemskeeper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ItemsKeeperApplication

fun main(args: Array<String>) {
    runApplication<ItemsKeeperApplication>(*args)
}
