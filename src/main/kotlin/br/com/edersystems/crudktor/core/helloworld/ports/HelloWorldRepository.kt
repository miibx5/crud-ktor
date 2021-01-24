/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:38:39
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.helloworld.ports

import br.com.edersystems.crudktor.core.helloworld.domain.HelloWorld

interface HelloWorldRepository {
    fun getHelloWorld(): HelloWorld
}