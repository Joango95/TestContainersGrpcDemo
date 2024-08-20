import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    idea
    kotlin("jvm") version "1.9.22"
    id("com.google.protobuf") version "0.9.4"
    id("maven-publish")
}

group = "com.joango"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    mavenLocal()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("com.google.protobuf:protobuf-java:3.25.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.0")
    implementation("io.grpc:grpc-protobuf:1.59.0")
}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.0"
        generatedFilesBaseDir = "$projectDir/src/generated-sources"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.59.0"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.0:jdk8@jar"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc") {
                    println("$rootDir/buildpo")
                    outputSubDir = "$rootDir/buildpo"
                }
                id("grpckt")
            }
        }
        all().forEach { task ->
            task.generateDescriptorSet = true
            task.descriptorSetOptions.path = "$projectDir/src/generated-sources/descriptors/testContainersDemo.dsc"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

sourceSets {
    main {
        proto {
            srcDirs("src/proto/data")
            srcDirs("src/proto/services")
        }
        java {
            java.srcDirs("build/generated/source/proto/main/java")
            java.srcDirs("build/generated/source/proto/main/grpc")
            java.srcDirs("build/generated/source/proto/main/grpckt")
        }
    }
}

tasks.withType<ProcessResources> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

idea {
    module {
        sourceDirs.add(file("$projectDir/lang/kotlin/src/generated/main/java"))
        sourceDirs.add(file("$projectDir/lang/kotlin/src/generated/main/grpc"))
    }
}