/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:41:47
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

class GenderNotFoundException(private val gender: String) : CrudKtorException() {

    override val message = "Gender $gender not found"

    override fun response() = ErrorResponseOrchestrator
        .createError(HttpStatusCode.BadRequest.value.toString(), message)

    override fun status() = HttpStatusCode.NotFound
}