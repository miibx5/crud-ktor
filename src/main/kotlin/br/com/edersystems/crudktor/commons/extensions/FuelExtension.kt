/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:12:05
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.extensions

import com.github.kittinunf.fuel.core.Response

val Response.json: String get() = String(data, Charsets.UTF_8)