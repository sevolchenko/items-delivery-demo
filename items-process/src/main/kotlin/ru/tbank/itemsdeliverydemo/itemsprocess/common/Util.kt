package ru.tbank.itemsdeliverydemo.itemsprocess.common

import org.camunda.bpm.engine.delegate.DelegateExecution

operator fun DelegateExecution.get(name: String): String = getVariable(name) as String

operator fun DelegateExecution.set(name: String, value: String?) = setVariable(name, value)
