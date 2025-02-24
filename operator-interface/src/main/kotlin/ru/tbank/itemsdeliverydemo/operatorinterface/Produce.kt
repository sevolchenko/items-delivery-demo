package ru.tbank.itemsdeliverydemo.operatorinterface

fun main() {
    println("Введи свой логин: ")

    val login = readln()

    while (true) {
        println("Для того, чтобы взять задачу в работу, нажми ENTER")

        readlnOrNull()

        val task = try {
            client.takeTask(login)
        } catch (e: Exception) {
            println("Сейчас нет задач, или нет свободных ячеек на складе")
            continue
        }

        val taskId = task.taskId

        println("Ты взял задачу в работу. TaskId: $taskId")

        println(task.instructions)

        readlnOrNull()

        try {
            client.finishHandling(taskId)
        } catch (e: Exception) {
            println("Что-то пошло не так")
            continue
        }

        println("Задача завершена успешно")

        Thread.sleep(1000)
    }
}
