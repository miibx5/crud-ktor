/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:53:49
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

class TypeAddressNotFoundException(private val typeAddress: String) : CrudKtorException() {

    override val message = "Type address $typeAddress not found"

    override fun response() = ErrorResponse.create(code).addError("typeAddress", typeAddress)

    override fun errorCode() = HttpStatusCode.NotFound
}