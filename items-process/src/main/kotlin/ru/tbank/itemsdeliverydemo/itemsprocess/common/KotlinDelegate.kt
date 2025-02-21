package ru.tbank.itemsdeliverydemo.itemsprocess.common

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

abstract class KotlinDelegate: JavaDelegate {

    abstract fun doExecute(context: DelegateExecution)

    override fun execute(p0: DelegateExecution?) = doExecute(p0!!)

}