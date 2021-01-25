/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:32:55
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.exceptions

import br.com.edersystems.crudktor.commons.exceptions.error.ErrorResponse
import br.com.edersystems.crudktor.commons.extensions.camelToSnakeCase
import io.ktor.http.HttpStatusCode

abstract class CrudKtorException : RuntimeException() {

    protected val code = javaClass
        .simpleName
        .replace("Exception", "")
        .camelToSnakeCase()
        .toUpperCase()

    abstract override val message: String
    abstract fun errorCode(): HttpStatusCode
    abstract fun response(): ErrorResponse
}