package ru.tbank.itemsdeliverydemo.itemscontroller

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IntegrationEnvironment {

    companion object {
        @Container
        @JvmStatic
        val DB_CONTAINER: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:16-alpine")
            .withDatabaseName("items-delivery-demo")
            .withUsername("user")
            .withPassword("password")

        @DynamicPropertySource
        @JvmStatic
        fun jdbcProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", DB_CONTAINER::getJdbcUrl)
            registry.add("spring.datasource.username", DB_CONTAINER::getUsername)
            registry.add("spring.datasource.password", DB_CONTAINER::getPassword)
        }
    }
}
