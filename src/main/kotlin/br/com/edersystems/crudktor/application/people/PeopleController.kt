/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 16:58:19
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people

import br.com.edersystems.crudktor.application.extensions.receiveUTF8Text
import br.com.edersystems.crudktor.application.people.request.PersonRequest
import br.com.edersystems.crudktor.application.people.response.PersonResponse
import br.com.edersystems.crudktor.commons.providers.ObjectMapperProvider
import br.com.edersystems.crudktor.core.people.PeopleService
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class PeopleController(
    private val mapper: ObjectMapper,
    private val service: PeopleService
) {
    suspend fun create(call: ApplicationCall) {

        val jsonRequest = call.receiveUTF8Text()

        val request = mapper.readValue(jsonRequest, PersonRequest::class.java)

        val personCreated = service.create(request.toPersonDTO())

        val personToReturn = mapper.writeValueAsString(PersonResponse.create(personCreated))

        println("\n PERSON SAVED: ${ObjectMapperProvider.provide().writeValueAsString(personCreated)}\n")

        call.respond(HttpStatusCode.Created, personToReturn)
    }

}