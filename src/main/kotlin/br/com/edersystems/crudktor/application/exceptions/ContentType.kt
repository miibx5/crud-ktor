/*
Project .....................: crud-ktor-app
Creation Date ...............: 28/01/2021 19:14:23
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.exceptions

import io.ktor.http.ContentType

object ContentType {
    val json = ContentType("application", ContentType.Application.Json.toString())
}