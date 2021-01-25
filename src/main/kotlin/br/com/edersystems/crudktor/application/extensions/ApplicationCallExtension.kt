/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:11:06
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.extensions

import br.com.edersystems.crudktor.commons.extensions.toUUID
import io.ktor.application.ApplicationCall
import io.ktor.request.receive
import java.security.InvalidParameterException

suspend fun ApplicationCall.receiveUTF8Text() = String(this.receive(), Charsets.UTF_8)

fun ApplicationCall.getParameter(parameter: String) =
    parameters[parameter] ?: throw InvalidParameterException(parameter)

fun ApplicationCall.getQueryParameter(parameter: String) = request.queryParameters[parameter]
    ?: throw InvalidParameterException(parameter)

fun ApplicationCall.getPersonId() = getParameter("id").toUUID()