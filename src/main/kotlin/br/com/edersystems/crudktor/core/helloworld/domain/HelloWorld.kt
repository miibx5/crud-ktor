/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:40:44
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.helloworld.domain

import br.com.edersystems.crudktor.core.helloworld.ports.dto.HelloWorldDTO

data class HelloWorld private constructor(val message: String) {
    companion object {
        fun create(dto: HelloWorldDTO) = HelloWorld(dto.message)
    }
}
