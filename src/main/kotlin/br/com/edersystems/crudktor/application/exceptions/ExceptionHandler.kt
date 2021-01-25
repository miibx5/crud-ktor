/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:20:26
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.exceptions

import br.com.edersystems.crudktor.commons.exceptions.CrudKtorException
import io.ktor.application.call
import io.ktor.features.StatusPages
import io.ktor.response.respond
import org.slf4j.LoggerFactory

object ExceptionHandler {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun handle(handler: StatusPages.Configuration) {
        handleException(handler)
    }

    private fun handleException(handler: StatusPages.Configuration) = handler.exception<CrudKtorException> {

        logger.warn("Application throws exception. Code: ${it.errorCode()} - Errors: ${it.response()}", it)

        call.respond(it.errorCode(), it.response())
    }


}