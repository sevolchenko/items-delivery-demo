package ru.tbank.itemsdeliverydemo.itemsprocess

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import java.util.Locale

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
    Locale.setDefault(Locale.US)
    runApplication<ItemsProcessApplication>(*args)
}
