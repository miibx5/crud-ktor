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

import br.com.edersystems.crudktor.application.extensions.getPersonId
import br.com.edersystems.crudktor.application.extensions.receiveUTF8Text
import br.com.edersystems.crudktor.application.people.request.PersonRequest
import br.com.edersystems.crudktor.application.people.response.PersonResponse
import br.com.edersystems.crudktor.application.response.Response
import br.com.edersystems.crudktor.core.people.PeopleService
import br.com.edersystems.crudktor.core.people.domain.Person
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class PeopleController(
    private val mapper: ObjectMapper,
    private val service: PeopleService
) {
    suspend fun getById(call: ApplicationCall) {

        val personId = call.getPersonId()

        val personToReturn = service.getById(personId)

        val response = getPersonResponse(personToReturn)

        call.respond(HttpStatusCode.OK, response)
        //call.respond(HttpStatusCode.OK, "Funciona merda")
    }

    suspend fun create(call: ApplicationCall) {

        val jsonRequest = call.receiveUTF8Text()

        val request = mapper.readValue<PersonRequest>(jsonRequest)

        val personCreated = service.create(request.toPersonDTO())

        val response = getPersonResponse(personCreated)

        call.respond(HttpStatusCode.Created, response)
    }

    private fun getPersonResponse(person: Person) =
        Response.create(HttpStatusCode.OK.value, PersonResponse.create(person))

}