plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.emortal.datadependency"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Minestom:Minestom:ba73c742f4")
    implementation("org.redisson:redisson:3.17.4")
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.6.1")
}

tasks {
    processResources {
        filesMatching("extension.json") {
            expand(project.properties)
        }
    }

    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        archiveBaseName.set(project.name)
        mergeServiceFiles()
    }

    build { dependsOn(shadowJar) }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}