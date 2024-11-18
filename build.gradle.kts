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
        val junitExtensionVersion: String by project
        val kotlinLoggingVersion: String by project
        val mockitoKotlinVersion: String by project

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.github.glytching:junit-extensions:$junitExtensionVersion")
        testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion")
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