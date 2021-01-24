/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:36:16
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.helloworld

import br.com.edersystems.crudktor.application.helloworld.response.HelloWorldResponse
import br.com.edersystems.crudktor.core.helloworld.HelloWorldService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class HelloWorldController(private val service: HelloWorldService) {

    suspend fun getHelloWorld(call: ApplicationCall) {
        val helloWorld = service.getHelloWorld()
        call.respond(HttpStatusCode.OK, HelloWorldResponse.create(helloWorld))
    }
}