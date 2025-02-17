package ru.tbank.itemsdeliverydemo.applicationsstorage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["ru.tbank.itemsdeliverydemo.common"])
class ApplicationsStorageApplication

fun main(args: Array<String>) {
    runApplication<ApplicationsStorageApplication>(*args)
}
