package com.joango.TestContainersSpringDemo.clients.config

import com.joango.services.ExternalServiceCommandsGrpc
import io.grpc.ManagedChannel
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.Closeable
import java.util.concurrent.TimeUnit

const val TERMINATION_DELAY_MILLISECOND = 15L

@Configuration
class ExternalServiceClientConfiguration(
    @Qualifier("externalServiceClientChannel") private val clientChannel: ManagedChannel
): Closeable {

    @Bean
    fun externalServiceClientGrpc(): ExternalServiceCommandsGrpc.ExternalServiceCommandsBlockingStub {
        return ExternalServiceCommandsGrpc.newBlockingStub(clientChannel)
    }

    override fun close() {
        if (!clientChannel.isShutdown) {
            clientChannel.shutdown().awaitTermination(TERMINATION_DELAY_MILLISECOND, TimeUnit.MILLISECONDS)
        }
    }
}