pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val kotlinVersion: String by settings
    val detektVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        id("io.gitlab.arturbosch.detekt") version detektVersion
    }
}

rootProject.name = "items-delivery-demo"

include("items-storage")
include("items-process")
include("items-controller")
include("items-keeper")
include("operator-back")