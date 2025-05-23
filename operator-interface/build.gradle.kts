group = "ru.tbank.items-delivery-demo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation(project(":common"))

    implementation("org.springframework:spring-webflux")
    implementation("io.projectreactor.netty:reactor-netty:1.1.19")

}

tasks.bootJar {
    enabled = false
}
tasks.bootRun {
    enabled = false
}
tasks.resolveMainClassName {
    enabled = false
}