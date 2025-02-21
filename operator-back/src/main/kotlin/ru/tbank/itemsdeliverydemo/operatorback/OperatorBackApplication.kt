package ru.tbank.itemsdeliverydemo.operatorback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = [
        "ru.tbank.itemsdeliverydemo.common",
        "ru.tbank.itemsdeliverydemo.operatorback"
    ]
)
class OperatorBackApplication

fun main(args: Array<String>) {
    runApplication<OperatorBackApplication>(*args)
}
