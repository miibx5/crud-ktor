/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:55:42
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.exceptions

import br.com.edersystems.crudktor.commons.exceptions.CrudKtorException
import br.com.edersystems.crudktor.commons.exceptions.error.ErrorResponseOrchestrator
import io.ktor.http.HttpStatusCode

class PublicPlaceNotFoundException(private val publicPlace: String) : CrudKtorException() {

    override val message = "Public place $publicPlace not found"

    override fun response() = ErrorResponseOrchestrator
        .createError(HttpStatusCode.BadRequest.value.toString(), message)

    override fun status() = HttpStatusCode.NotFound
}