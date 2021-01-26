/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:48:24
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.exceptions

import br.com.edersystems.crudktor.commons.exceptions.error.ErrorResponseOrchestrator
import io.ktor.http.HttpStatusCode

class InvalidUuidFormatException(private val uuidValue: String) : CrudKtorException() {

    override val message = "Invalid UUID format. It was not possible to parse value $uuidValue to UUID"

    override fun response() =
        ErrorResponseOrchestrator.createError(HttpStatusCode.BadRequest.value.toString(), message)

    override fun status() = HttpStatusCode.BadRequest
}