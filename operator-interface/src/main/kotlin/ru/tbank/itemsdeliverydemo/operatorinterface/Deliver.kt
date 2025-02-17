package ru.tbank.itemsdeliverydemo.operatorinterface

fun main() {
    while (true) {
        println("Для того, чтобы выдать предмет, введи код получения и нажми Enter")

        val code = readln()

        val task = try {
            client.pickupTask(code)
        } catch (e: Exception) {
            println("Неверный код")
            continue
        }

        val taskId = task.taskId

        println("Ты выдаешь предмет по задаче $taskId")

        println(task.instructions)

        try {
            client.finishPickup(taskId)
        } catch (e: Exception) {
            println("Что-то пошло не так")
            continue
        }

        println("Товар выдан успешно")

        Thread.sleep(1000)
    }
}
