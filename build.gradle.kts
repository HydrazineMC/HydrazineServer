plugins {
	application
	id("org.jetbrains.kotlin.jvm") version "1.6.21"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.github.hydrazinemc"
version = "0.1.0"

repositories {
	mavenCentral()
	maven(url = "https://jitpack.io")
}

dependencies {
	implementation("com.github.Minestom:Minestom:-SNAPSHOT")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
	implementation("io.github.microutils:kotlin-logging:2.1.21")
}

application {
	mainClass.set("io.github.hydrazinemc.server.HydrazineServer")

	// This is deprecated, but the Shadow plugin requires it
    mainClassName = "io.github.hydrazinemc.server.HydrazineServer"
}

java.toolchain.languageVersion.set(
	JavaLanguageVersion.of(17)
)

tasks {
	compileKotlin {
		targetCompatibility = "17"
	}
	shadowJar {
		archiveFileName.set("../HydrazineServer.jar")
	}
	build {
		dependsOn("shadowJar")
	}
}