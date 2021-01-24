/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:37:11
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.helloworld

import br.com.edersystems.crudktor.core.helloworld.domain.HelloWorld
import br.com.edersystems.crudktor.core.helloworld.ports.HelloWorldRepository

class HelloWorldService(private val repository: HelloWorldRepository) {

    fun getHelloWorld(): HelloWorld {
        return repository.getHelloWorld()
    }
}