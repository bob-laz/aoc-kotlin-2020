import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.21"
}

application {
    mainClass.set("util.Runner")
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.reflections", "reflections", "0.9.12")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    testImplementation("org.hamcrest", "hamcrest", "2.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.test {
    useJUnitPlatform()
}