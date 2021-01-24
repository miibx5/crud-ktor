/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:50:58
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.helloworld.response

import br.com.edersystems.crudktor.core.helloworld.domain.HelloWorld

class HelloWorldResponse private constructor(val message: String) {
    companion object {
        fun create(helloWorld: HelloWorld) = HelloWorldResponse(helloWorld.message)
    }
}