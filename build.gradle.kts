import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
}

group = "me.bienen.tv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://m2.dv8tion.net/releases")
        name = "m2-dv8tion"
    }
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("net.dv8tion:JDA:4.3.0_297")
    implementation("org.json:json:20141113")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}