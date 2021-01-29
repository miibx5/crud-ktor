/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:22:13
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor

import br.com.edersystems.crudktor.application.people.request.PersonRequest
import br.com.edersystems.crudktor.application.people.response.PersonResponse
import br.com.edersystems.crudktor.application.response.Response
import br.com.edersystems.crudktor.commons.extensions.readJson
import br.com.edersystems.crudktor.commons.providers.ObjectMapperProvider
import br.com.edersystems.crudktor.core.people.domain.Person
import io.ktor.http.HttpStatusCode
import java.time.LocalDateTime
import java.util.UUID

fun main() {
    val mapper = ObjectMapperProvider.provide()
    val json = readJson("people/leticia")
    val request = mapper.readValue(json, PersonRequest::class.java)
    println(request)
    val person = Person.create(request.toPersonDTO()).apply {
        id = UUID.randomUUID()
        createdAt = LocalDateTime.now()
        updatedAt = createdAt
        addresses.forEach {
            it.apply {
                id = UUID.randomUUID()
                createdAt = LocalDateTime.now()
                updatedAt = createdAt
            }
        }
        documents.forEach {
            it.apply {
                id = UUID.randomUUID()
                createdAt = LocalDateTime.now()
                updatedAt = createdAt
            }
        }
        phones.forEach {
            it.apply {
                id = UUID.randomUUID()
                createdAt = LocalDateTime.now()
                updatedAt = createdAt
            }
        }
    }
    val personResponse = PersonResponse.create(person)
    println(personResponse)

    val response = mapper.writeValueAsString(Response.create(HttpStatusCode.OK.value, personResponse))
    println(response)
}