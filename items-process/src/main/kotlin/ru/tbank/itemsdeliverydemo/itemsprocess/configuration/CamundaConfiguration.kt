package ru.tbank.itemsdeliverydemo.itemsprocess.configuration

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration
import org.camunda.bpm.engine.variable.Variables
import org.camunda.bpm.spring.boot.starter.configuration.Ordering
import org.camunda.bpm.spring.boot.starter.configuration.impl.AbstractCamundaConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Configuration
class CamundaConfiguration {

    @Component
    @Order(Ordering.DEFAULT_ORDER + 1)
    class CustomCamundaConfiguration : AbstractCamundaConfiguration() {
        override fun preInit(processEngineConfiguration: SpringProcessEngineConfiguration) {
            // processEngineConfiguration.customIncidentHandlers = listOf(customIncidentHandler)
            processEngineConfiguration.isDeployChangedOnly = true
            processEngineConfiguration.defaultSerializationFormat = Variables.SerializationDataFormats.JSON.name
        }
    }

//    @Bean
//    fun createAnyIncidentAction(
//        incidentHandler: IncidentHandler
//    ) = object : CreateAnyIncidentAction {
//        override fun execute(executionContext: ExecutionEntity) {
//            incidentHandler.handleIncidentOnCreation(executionContext)
//        }
//    }
//
//    @Bean
//    fun solveAnyIncidentAction(
//        incidentHandler: IncidentHandler
//    ) = object : SolveAnyIncidentAction {
//        override fun execute(executionContext: ExecutionEntity) {
//            incidentHandler.solveIncident(executionContext)
//        }
//    }
}
