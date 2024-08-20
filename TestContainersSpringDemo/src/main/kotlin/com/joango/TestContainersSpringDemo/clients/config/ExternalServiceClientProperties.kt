package com.joango.TestContainersSpringDemo.clients.config

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExternalServiceClientProperties(
    private val configuration: ExternalServiceClientData
) {
    @Bean("externalServiceClientChannel")
    fun configureChannel(): ManagedChannel {
        return ManagedChannelBuilder.forAddress(configuration.host, configuration.port)
            .usePlaintext()
            .build()
    }
}

@ConfigurationProperties(prefix = "management.external-service")
data class ExternalServiceClientData(
    var host: String,
    var port: Int
)
