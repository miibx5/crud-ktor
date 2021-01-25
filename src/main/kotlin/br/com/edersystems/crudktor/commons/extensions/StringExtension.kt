/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:08:10
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.extensions

import br.com.edersystems.crudktor.commons.exceptions.InvalidUuidFormatException
import java.util.UUID

fun String.getOnlyNumbers(): String {
    val onlyNumbers = "[^0-9]".toRegex()

    return this.replace(onlyNumbers, "")
}

fun String.camelToSnakeCase() = this
    .replace("([a-z])([A-Z]+)".toRegex(), "$1_$2")

fun String.toUUID(): UUID = runCatching { UUID.fromString(this) }
    .getOrElse { throw InvalidUuidFormatException(this) }