
 plugins {
    id("buildlogic.kotlin-application-conventions")
    id("io.ktor.plugin") version "2.3.9"
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    implementation("io.ktor:ktor-server-core:2.3.9")
    implementation("io.ktor:ktor-server-netty:2.3.9")
}

repositories {
    mavenCentral()
}

repositories {
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}

application {
    mainClass = "com.example.AppKt"
}
