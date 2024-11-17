pluginManagement {
    repositories {
        mavenCentral()
    }

    plugins {
        id("org.springframework.boot") version "3.3.5"
        id("io.spring.dependency-management") version "1.1.4"
        kotlin("jvm") version "1.9.25"
        kotlin("plugin.spring") version "1.9.25"
    }
}

rootProject.name = "items-delivery-demo"

include("items-storage")
include("operator-back")