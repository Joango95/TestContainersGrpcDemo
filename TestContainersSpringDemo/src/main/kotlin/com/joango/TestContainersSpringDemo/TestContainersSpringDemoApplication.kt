package com.joango.TestContainersSpringDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TestContainersSpringDemoApplication

fun main(args: Array<String>) {
	runApplication<TestContainersSpringDemoApplication>(*args)
}
