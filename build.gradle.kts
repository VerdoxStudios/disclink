plugins {
    id("java")
}

group = "org.verdox"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    // Paper dependency
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    // Discord JDA
    implementation("net.dv8tion:JDA:5.3.2")
}