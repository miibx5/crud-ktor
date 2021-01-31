/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:06:47
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.helloworld

import br.com.edersystems.crudktor.commons.client.FuelHttpClientMethod
import br.com.edersystems.crudktor.commons.extensions.readJson
import br.com.edersystems.crudktor.config.environments.baseUrl
import br.com.edersystems.crudktor.config.integration.IntegrationTest
import io.ktor.http.HttpStatusCode
import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import net.javacrumbs.jsonunit.core.Option
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(IntegrationTest::class)
internal class HelloWorldControllerTest {

    @Nested
    @DisplayName("When call hello world endpoint")
    inner class GetHelloWorld {

        @Test
        @DisplayName("Return https status 200 when call hello world endpoint")
        fun `return https status 200 when call hello world endpoint`() {
            val expected = readJson("hello_world/hello_world_response")

            val (response, statusCode) = FuelHttpClientMethod.get("$baseUrl/hello")

            assertThat(statusCode).isEqualTo(HttpStatusCode.OK.value)
            assertThatJson(expected).`when`(Option.IGNORING_ARRAY_ORDER).isEqualTo(response)
        }
    }
}