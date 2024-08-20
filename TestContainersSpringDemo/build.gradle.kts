import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	id("com.google.protobuf") version "0.9.4"
	kotlin("plugin.jpa") version "1.9.10"
}

group = "com.joango"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("com.joango:TestProto:0.0.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.postgresql:postgresql:42.5.4")


	implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
	implementation("com.google.protobuf:protobuf-java:3.25.0")
	implementation("io.grpc:grpc-kotlin-stub:1.4.0")
	implementation("io.grpc:grpc-protobuf:1.59.0")

	implementation("io.github.lognet:grpc-spring-boot-starter:5.1.5")
	implementation("com.google.protobuf:protobuf-java-util:3.25.2")

	implementation("io.github.microutils:kotlin-logging:3.0.4")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("io.github.lognet:grpc-spring-boot-starter:5.1.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.testcontainers:junit-jupiter:1.19.3")
	testImplementation("org.testcontainers:postgresql:1.19.3")
	testImplementation("org.wiremock.integrations.testcontainers:wiremock-testcontainers-module:1.0-alpha-13")
	testImplementation("org.junit-pioneer:junit-pioneer:2.2.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}


tasks.withType<Test> {
	useJUnitPlatform()
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}


tasks.named<Jar>("jar") {
	enabled = false
}