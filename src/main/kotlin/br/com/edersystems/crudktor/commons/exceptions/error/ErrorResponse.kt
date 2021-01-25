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
    val errors: MutableMap<String, Any>
) {
    companion object {
        fun create(code: String) = ErrorResponse(
            code = code,
            errors = mutableMapOf()
        )
    }

    fun addError(key: String, value: Any) = this.apply { errors[key] = value }
}