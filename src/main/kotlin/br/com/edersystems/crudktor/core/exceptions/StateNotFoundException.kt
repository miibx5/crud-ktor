/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:01:13
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.exceptions

import br.com.edersystems.crudktor.commons.exceptions.CrudKtorException
import br.com.edersystems.crudktor.commons.exceptions.error.ErrorResponse
import io.ktor.http.HttpStatusCode

class StateNotFoundException(private val state: String) : CrudKtorException() {

    override val message = "State $state not found"

    override fun response() = ErrorResponse.create(code).addError("personType", state)

    override fun errorCode() = HttpStatusCode.NotFound
}