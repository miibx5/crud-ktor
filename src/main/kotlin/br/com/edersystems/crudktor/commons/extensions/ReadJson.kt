/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:15:01
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.extensions

fun readJson(fileName: String) = ClassLoader.getSystemResource("json/$fileName.json").readText()