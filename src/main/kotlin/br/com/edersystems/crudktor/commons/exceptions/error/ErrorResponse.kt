/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:33:38
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.exceptions.error

class ErrorResponse private constructor(
    val code: String,
    val message: String
) {
    companion object {
        fun create(code: String, message: String) = ErrorResponse(
            code = code,
            message = message
        )
    }
}