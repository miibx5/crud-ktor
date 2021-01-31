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
import br.com.edersystems.crudktor.commons.client.FuelHttpClientMethod
import br.com.edersystems.crudktor.commons.extensions.readJson
import br.com.edersystems.crudktor.commons.providers.ObjectMapperProvider
import br.com.edersystems.crudktor.config.environments.baseUrl
import br.com.edersystems.crudktor.config.integration.IntegrationTest
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.infrastructure.people.PeopleRepositoryAdapter
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.http.HttpStatusCode
import net.javacrumbs.jsonunit.assertj.JsonAssertions
import net.javacrumbs.jsonunit.core.Option
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(IntegrationTest::class)
internal class PeopleControllerTest {

    private val repository = PeopleRepositoryAdapter()
    private val mapper = ObjectMapperProvider.provide()


    @Nested
    @DisplayName("Given a valid person id then return a status 200")
    inner class GetHelloWorld {
        private val expected = readJson("people/leticia")
        private val request = mapper.readValue<PersonRequest>(expected)
        private val personToBeSaved = Person.create(request.toPersonDTO())

        @Test
        @DisplayName("Return https status 200 when call person by id endpoint")
        fun `return https status 200 when call person by id endpoint`() {
            val personSaved = repository.create(personToBeSaved)

            val (response, statusCode) = FuelHttpClientMethod.get("$baseUrl/person/${personSaved.id}")

            Assertions.assertThat(statusCode).isEqualTo(HttpStatusCode.OK.value)
            JsonAssertions.assertThatJson(expected).`when`(Option.IGNORING_ARRAY_ORDER).isEqualTo(response)
        }
    }

}