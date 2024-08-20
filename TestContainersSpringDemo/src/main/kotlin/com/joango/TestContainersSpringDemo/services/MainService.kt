package com.joango.TestContainersSpringDemo.services

import com.joango.ResponseCode
import com.joango.TestContainersSpringDemo.clients.ExternalServiceClient
import com.joango.services.CreatePersonResponse
import com.joango.services.MainServiceCommandsGrpcKt
import com.joango.services.ProcessAddressBookCommand
import com.joango.services.ProcessAddressBookResponse
import mu.KotlinLogging
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class MainService(
    val externalServiceClient: ExternalServiceClient
): MainServiceCommandsGrpcKt.MainServiceCommandsCoroutineImplBase() {
    private val logger = KotlinLogging.logger() {}

    override suspend fun processAddressBook(request: ProcessAddressBookCommand): ProcessAddressBookResponse {
        logger.info { "Received process address book request: ${request.id}" }
        return try {
            val createAddressBookResponse =
                externalServiceClient.sendCreateAddressBookRequest(request.addressBook)

            val createPersonResponseList =
                request.addressBook.peopleList
                    .map {
                        val personRequested = externalServiceClient.getPersonById(it.id.toString())
                        if (!personRequested.hasPerson()) {
                            externalServiceClient.sendCreatePersonRequest(it)
                        } else {
                            CreatePersonResponse.newBuilder()
                                .setPerson(personRequested.person)
                                .setCode(ResponseCode.OK)
                                .build()
                        }
                    }
            if (createAddressBookResponse.code == ResponseCode.OK
                && createPersonResponseList.all { it.code == ResponseCode.OK }) {

                ProcessAddressBookResponse.newBuilder()
                    .setCode(ResponseCode.OK)
                    .setMessage("Process address book returned OK")
                    .build()
            } else {
                val addressBookResponses = mutableListOf(createAddressBookResponse)

                val addressBookErrors = addressBookResponses.filter { it.code != ResponseCode.OK }
                val personListErrors = createPersonResponseList.filter { it.code != ResponseCode.OK }

                val errorMessages = mutableListOf(
                    addressBookErrors.map { it.message },
                    personListErrors.map { it.message }
                ).flatten()


                ProcessAddressBookResponse.newBuilder()
                    .setCode(ResponseCode.OK)
                    .setMessage("Error processing address book: $errorMessages")
                    .build()
            }
        } catch (e: Exception) {
            ProcessAddressBookResponse.newBuilder()
                .setCode(ResponseCode.ERROR)
                .setMessage("Error processing address book: ${e.message}")
                .build()
        }
    }
}