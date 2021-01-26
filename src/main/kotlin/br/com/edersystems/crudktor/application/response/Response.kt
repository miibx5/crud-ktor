/*
Project .....................: crud-ktor-app
Creation Date ...............: 25/01/2021 19:20:21
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.response

data class Response private constructor(
    val code: Int,
    val data: Any
) {
    companion object {
        fun create(code: Int, data: Any) = Response(code, data)
    }
}
