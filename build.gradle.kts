plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.emortal.datadependency"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("com.github.Minestom:Minestom:ba73c742f4")
    compileOnly("com.velocitypowered:velocity-api:3.0.1")
    annotationProcessor("com.velocitypowered:velocity-api:3.0.1")
    implementation("org.redisson:redisson:3.17.4")
    implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.6.1")
    implementation("mysql:mysql-connector-java:8.0.29")
    implementation("com.zaxxer:HikariCP:5.0.1")
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

    shadowJar {
        relocate("com.zaxxer.hikari", "dev.emortal.datadependency.libs.hikari")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}