package com.joango.TestContainersSpringDemo.clients

import com.joango.AddressBookDTO
import com.joango.PersonDTO
import com.joango.services.CreatePersonResponse
import com.joango.services.CreateAddressBookResponse
import com.joango.services.GetPersonResponse

interface ExternalServiceClient {
    fun getPersonById(personId: String): GetPersonResponse
    fun sendCreatePersonRequest(personDTO: PersonDTO): CreatePersonResponse
    fun sendCreateAddressBookRequest(addressBookDTO: AddressBookDTO): CreateAddressBookResponse
}