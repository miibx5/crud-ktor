/*
Project .....................: crud-ktor-app
Creation Date ...............: 25/01/2021 19:34:49
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.exceptions.error

import br.com.edersystems.crudktor.application.response.Response
import br.com.edersystems.crudktor.commons.exceptions.CrudKtorException

object ErrorResponseOrchestrator {

    fun createError(ex: CrudKtorException): Response {
        return buildError(ex.code, ex.message)
    }

    fun createError(code: String, message: String): Response {
        return buildError(code, message)
    }

    private fun buildError(code: String, message: String): Response {
        return Response.create(code.toInt(), listOf(ErrorResponse.create(code, message)))
    }
}