import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.gitlab.arturbosch.detekt")
}

allprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    repositories {
        mavenCentral()
    }

    dependencies {
        val detektVersion: String by project

        implementation("org.springframework.boot:spring-boot-starter")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
    }

    tasks.detekt {
        autoCorrect = true
        config = files("${project.rootDir}/config/detekt/detekt.yaml")
    }

    tasks.check {
        dependsOn("detekt")
    }
}

tasks.withType<BootJar> {
    enabled = false
}