package ru.tbank.itemsdeliverydemo.itemsstorage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ItemsStorageApplication

fun main(args: Array<String>) {
    runApplication<ItemsStorageApplication>(*args)
}
