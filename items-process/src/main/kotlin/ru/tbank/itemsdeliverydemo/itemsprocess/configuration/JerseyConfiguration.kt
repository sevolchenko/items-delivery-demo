package ru.tbank.itemsdeliverydemo.itemsprocess.configuration

import jakarta.ws.rs.ApplicationPath
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerResponseContext
import jakarta.ws.rs.container.ContainerResponseFilter
import jakarta.ws.rs.ext.Provider
import org.camunda.bpm.engine.rest.impl.CamundaRestResources
import org.camunda.bpm.engine.rest.mapper.JacksonConfigurator
import org.camunda.bpm.spring.boot.starter.rest.CamundaJerseyResourceConfig
import org.springframework.stereotype.Component


@Component
@ApplicationPath("/rest")
class JerseyConfiguration : CamundaJerseyResourceConfig() {
    override fun registerCamundaRestResources() {
        registerClasses(CamundaRestResources.getResourceClasses())
        registerClasses(
            CamundaRestResources.getConfigurationClasses()
                .also { it.remove(JacksonConfigurator::class.java) }
        )
    }

    override fun registerAdditionalResources() {
        registerClasses(CORSResponseFilter::class.java)
    }
}

@Provider
class CORSResponseFilter : ContainerResponseFilter {
    override fun filter(requestContext: ContainerRequestContext, responseContext: ContainerResponseContext) {
        val headers = responseContext.headers

        headers.add("Access-Control-Allow-Origin", "*")
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        headers.add("Access-Control-Allow-Headers", "Authorization, X-Requested-With, Content-Type")
    }
}
