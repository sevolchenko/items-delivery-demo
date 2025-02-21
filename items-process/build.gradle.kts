plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "ru.tbank.items-delivery-demo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.camunda.bpm:camunda-bom:7.21.0"))
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp")
    implementation("org.camunda.spin:camunda-spin-dataformat-json-jackson")
    implementation("org.camunda.bpm:camunda-engine-plugin-spin")
    implementation("org.camunda.spin:camunda-spin-dataformat-all")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")

    //implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation(project(":common"))
    implementation("com.zaxxer:HikariCP")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

tasks.withType<Test> {
    useJUnitPlatform()
}