package ru.tbank.itemsdeliverydemo.operatorback.component

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class PickupCodeGenerator {

    fun generate() = Random.nextInt(100000, 999999).toString()
}
