package com.joango.TestContainersSpringDemo.clients.impl

import com.joango.AddressBookDTO
import com.joango.PersonDTO
import com.joango.ResponseCode
import com.joango.TestContainersSpringDemo.clients.ExternalServiceClient
import com.joango.services.*
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class ExternalServiceClientImpl(
    private val externalServiceClient: ExternalServiceCommandsGrpc.ExternalServiceCommandsBlockingStub
): ExternalServiceClient {

    private val logger = KotlinLogging.logger {}

    override fun getPersonById(personId: String): GetPersonResponse {
        val response = try {
            val entityId = EntityId.newBuilder().setId(personId).build()

            logger.info { "Sending getPersonById request id:$personId" }

            externalServiceClient.getPersonById(entityId)
        } catch (ex: Exception) {
            logger.error(ex) { "Error getting person $personId: ${ex.message}" }
            GetPersonResponse.newBuilder()
                .setCode(ResponseCode.ERROR)
                .setMessage(ex.message)
                .build()
        }
        logger.info { "Get person by id $personId request response ${response.code}: ${response.message}" }

        return response
    }

    override fun sendCreatePersonRequest(personDTO: PersonDTO): CreatePersonResponse {
        val response = try {
            val createPersonCommand = CreatePersonCommand.newBuilder().setPerson(personDTO).build()

            logger.info { "Sending createPerson request id:${personDTO.id}, name: ${personDTO.name}" }

            externalServiceClient.createPerson(createPersonCommand)

        } catch (ex: Exception) {
            logger.error(ex) { "Error sending create person request: ${ex.message}" }
            CreatePersonResponse.newBuilder()
                .setCode(ResponseCode.ERROR)
                .setMessage(ex.message)
                .build()
        }
        logger.info { "Create person ${personDTO.id} request response ${response.code}: ${response.message}" }
        return response
    }

    override fun sendCreateAddressBookRequest(addressBookDTO: AddressBookDTO): CreateAddressBookResponse {
        val response = try {
            val createAddressBookCommand = CreateAddressBookCommand
                .newBuilder()
                .setAddressBook(addressBookDTO)
                .build()

            logger.info { "Sending createPerson request id: ${addressBookDTO.id}" }

            externalServiceClient.createAddressBook(createAddressBookCommand)
        } catch (ex: Exception) {
            logger.error(ex) { "Error sending create address book request: ${ex.message}" }
            CreateAddressBookResponse.newBuilder()
                .setCode(ResponseCode.ERROR)
                .setMessage(ex.message)
                .build()
        }
        logger.info { "Create address book ${addressBookDTO.id} request response ${response.code}: ${response.message}" }
        return response
    }
}