val assertjCoreVersion: String by project
val exposedVersion: String by project
val fuelVersion: String by project
val flywayDbVersion: String by project
val hikariCpVersion: String by project
val jacksonVersion: String by project
val jdbcPostgresVersion: String by project
val jsonUnitVersion: String by project
val junitJupiterVersion: String by project
val koinVersion: String by project
val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val mockkVersion: String by project
val testContainersVersion: String by project
val wiremockJre8Version: String by project

plugins {
    application
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "br.com.edersystems.crudktor"
version = "0.0.1"


repositories {
    mavenLocal()
    jcenter()
}

dependencies {

    // Dependency Injection
    implementation("org.koin:koin-ktor:$koinVersion")

    // Database
    implementation("com.zaxxer:HikariCP:$hikariCpVersion")
    implementation("org.flywaydb:flyway-core:$flywayDbVersion")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.postgresql:postgresql:$jdbcPostgresVersion")

    //Kotlin
    kotlin("kotlin-bom")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    // Serialization
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    // Ktor
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")

    // Logs
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Test Engine
    testImplementation("org.assertj:assertj-core:$assertjCoreVersion")
    testImplementation("net.javacrumbs.json-unit:json-unit:$jsonUnitVersion")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:$jsonUnitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testImplementation("org.testcontainers:junit-jupiter:$testContainersVersion")
    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("com.github.tomakehurst:wiremock-jre8:$wiremockJre8Version")
}

tasks {
    application {
        mainClassName = "br.com.edersystems.crudktor.CrudKtorApplicationKt"
    }

    assemble { dependsOn(shadowJar) }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    test {
        useJUnitPlatform()
    }
}