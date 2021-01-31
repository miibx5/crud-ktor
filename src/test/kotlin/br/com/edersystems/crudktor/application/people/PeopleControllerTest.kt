/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:07:14
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people

import br.com.edersystems.crudktor.application.people.request.PersonRequest
import br.com.edersystems.crudktor.application.people.response.CreatedPersonResponse
import br.com.edersystems.crudktor.application.people.response.PersonResponse
import br.com.edersystems.crudktor.application.response.Response
import br.com.edersystems.crudktor.commons.client.FuelHttpClientMethod
import br.com.edersystems.crudktor.commons.extensions.readJson
import br.com.edersystems.crudktor.commons.providers.ObjectMapperProvider
import br.com.edersystems.crudktor.config.environments.baseUrl
import br.com.edersystems.crudktor.config.integration.IntegrationTest
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.infrastructure.people.PeopleRepositoryAdapter
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.http.HttpStatusCode
import kotlin.test.assertNotNull
import net.javacrumbs.jsonunit.assertj.assertThatJson
import net.javacrumbs.jsonunit.core.Option
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(IntegrationTest::class)
internal class PeopleControllerTest {

    private val repository = PeopleRepositoryAdapter()
    private val mapper = ObjectMapperProvider.provide()

    @Nested
    inner class CreatePerson {

        @Test
        @DisplayName("Return https status 201 when call create person endpoint")
        fun `return https status 201 when call create person endpoint`() {

            val jsonRequest = readJson("people/leticia")

            val (jsonResponse, statusCode) = FuelHttpClientMethod.post("$baseUrl/person", jsonRequest)

            val createdPerson = mapper.readValue<CreatedPersonResponse>(getPersonObjectNode(jsonResponse))

            assertThat(statusCode).isEqualTo(HttpStatusCode.Created.value)

            assertThat(createdPerson).isInstanceOf(CreatedPersonResponse::class.java)

            assertNotNull(createdPerson.id)
        }

        private fun getPersonObjectNode(jsonResponse: String) = mapper.readTree(jsonResponse).get("data").toString()
    }

    @Nested
    @DisplayName("Given a valid person id then return a status 200")
    inner class GetPersonById {

        @Test
        @DisplayName("Return https status 200 when call person by id endpoint")
        fun `return https status 200 when call person by id endpoint`() {

            val jsonRequest = readJson("people/leticia")
            val request = mapper.readValue<PersonRequest>(jsonRequest)
            val personToBeSaved = Person.create(request.toPersonDTO())
            val personSaved = repository.create(personToBeSaved)
            val personJsonResponse = getPersonByIdJsonResponse(personSaved)

            val (jsonResponse, statusCode) = FuelHttpClientMethod.get("$baseUrl/person/${personSaved.id}")

            assertThat(statusCode).isEqualTo(HttpStatusCode.OK.value)

            assertThatJson(jsonResponse).`when`(Option.IGNORING_ARRAY_ORDER).isEqualTo(personJsonResponse)
        }

        private fun getPersonByIdJsonResponse(personSaved: Person) =
            mapper.writeValueAsString(
                Response.create(
                    HttpStatusCode.OK.description,
                    PersonResponse.create(personSaved)
                )
            )
    }
}