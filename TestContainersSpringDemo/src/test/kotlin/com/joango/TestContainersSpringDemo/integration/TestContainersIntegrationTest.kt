package com.joango.TestContainersSpringDemo.integration

import com.google.protobuf.Timestamp
import com.joango.AddressBookDTO
import com.joango.PersonDTO
import com.joango.PhoneNumberDTO
import com.joango.PhoneType
import com.joango.ResponseCode
import com.joango.TestContainersSpringDemo.TestContainersSpringDemoApplication
import com.joango.services.MainServiceCommandsGrpc
import com.joango.services.ProcessAddressBookCommand
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.datetime.Clock
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.junitpioneer.jupiter.DisableIfTestFails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.MountableFile
import org.wiremock.integrations.testcontainers.WireMockContainer
import kotlin.test.assertEquals

@SpringBootTest(
    classes = [TestContainersSpringDemoApplication::class],
)
@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@DisableIfTestFails
@Import(TestContainersIntegrationTestConfig::class)
class TestContainersIntegrationTest(
    @Autowired
    val testContainersIntegrationTestConfig: TestContainersIntegrationTestConfig
) {

    private val containerTestLocalhostChannel: ManagedChannel = ManagedChannelBuilder
        .forAddress(TestContainersIntegrationTestContainers.LOCALHOST, testContainersIntegrationTestConfig.mainServicePort)
        .usePlaintext()
        .build()

    private val mainServiceStub: MainServiceCommandsGrpc.MainServiceCommandsBlockingStub =
        MainServiceCommandsGrpc.newBlockingStub(containerTestLocalhostChannel)


    @Order(1)
    @Test
    fun `context should be created successfully`() {}

    @Order(2)
    @Test
    fun `should be able to connect to send create person request`() {
        val personOne = PersonDTO.newBuilder()
            .setId(12345)
            .setName("George")
            .setEmail("george@anything.com")
            .setLastUpdated(Timestamp.newBuilder()
                .setSeconds(Clock.System.now().epochSeconds)
            )
            .addPhones(
                PhoneNumberDTO.newBuilder()
                .setType(PhoneType.PHONE_TYPE_HOME)
                .setNumber("+112345")
                .build()
            )
            .build()

        val personTwo = PersonDTO.newBuilder()
            .setId(67890)
            .setName("Juan")
            .setEmail("juan@anything.com")
            .setLastUpdated(Timestamp.newBuilder()
                .setSeconds(Clock.System.now().epochSeconds)
            )
            .addPhones(PhoneNumberDTO.newBuilder()
                .setType(PhoneType.PHONE_TYPE_WORK)
                .setNumber("+8837434")
                .build()
            )
            .build()

        val personThree = PersonDTO.newBuilder()
            .setId(654321)
            .setName("Karla")
            .setEmail("karla@anything.com")
            .setLastUpdated(Timestamp.newBuilder()
                .setSeconds(Clock.System.now().epochSeconds)
            )
            .addPhones(PhoneNumberDTO.newBuilder()
                .setType(PhoneType.PHONE_TYPE_MOBILE)
                .setNumber("+7654312")
                .build()
            )
            .build()

        val personListToProcess = listOf(personOne, personTwo, personThree)
        val addressBookToProcess = AddressBookDTO.newBuilder()
            .setId("newAddressId")
            .addAllPeople(personListToProcess)

        val processAddressBookCommand = ProcessAddressBookCommand.newBuilder()
            .setId("NewProcessAddressBookCommand")
            .setAddressBook(addressBookToProcess)
            .build()

        val processAddressBookResponse = mainServiceStub.processAddressBook(processAddressBookCommand)

        assertEquals(processAddressBookResponse.code, ResponseCode.OK)
    }

}

@Component
data class TestContainersIntegrationTestConfig(
    @Value("\${grpc.port}")
    var mainServicePort: Int,
    @Value("\${management.external-service.port}")
    var externalServicePort: Int,
)

@Component
@Testcontainers
@org.springframework.core.annotation.Order(1)
class TestContainersIntegrationTestContainers(){

    companion object {
        const val LOCALHOST = "localhost"
        private const val POSTGRES_PORT = 5432
        private const val POSTGRES_USER = "postgres"
        private const val POSTGRES_PASSWORD = "postgres"
        private const val POSTGRES_DB = "testContainersDemo"
    }

    @Container
    private val postgresTestContainer = PostgreSQLContainer("postgres:9.6.12")
        .withExposedPorts(POSTGRES_PORT)
        .withUsername(POSTGRES_USER)
        .withPassword(POSTGRES_PASSWORD)
        .withDatabaseName(POSTGRES_DB)

    @Container
    private val wireMockContainer = WireMockContainer("wiremock/wiremock:3.4.2")
        .withExposedPorts(5052)
        .withCliArg("--verbose")
        .withCliArg("--global-response-templating")
        .withCopyFileToContainer(
            MountableFile.forClasspathResource(
                "testcontainers/wiremock/data/grpc/testContainersDemo.dsc"),
            "/home/wiremock/grpc/testContainersDemo.dsc"
        )
        .withCopyFileToContainer(
            MountableFile.forClasspathResource(
                "testcontainers/wiremock/data/mappings/createPersonRequest.json"),
            "/home/wiremock/mappings/createPersonRequest.json"
        )
        .withCopyFileToContainer(
            MountableFile.forClasspathResource(
                "testcontainers/wiremock/data/mappings/createAddressBookRequest.json"),
            "/home/wiremock/mappings/createAddressBookRequest.json"
        )
        .withCopyFileToContainer(
            MountableFile.forClasspathResource(
                "testcontainers/wiremock/data/mappings/getPersonByIdRequest.json"),
            "/home/wiremock/mappings/getPersonByIdRequest.json"
        )
        .withCopyFileToContainer(
            MountableFile.forClasspathResource(
                "testcontainers/wiremock/extensions/wiremock-grpc-extension-standalone-0.4.0.jar"),
            "/var/wiremock/extensions/wiremock-grpc-extension-standalone-0.4.0.jar"
        )

    init {
        wireMockContainer.portBindings = listOf("5052:8080")
        wireMockContainer.start()
        postgresTestContainer.portBindings = listOf("${POSTGRES_PORT}:${POSTGRES_PORT}")
        postgresTestContainer.start()
    }
}