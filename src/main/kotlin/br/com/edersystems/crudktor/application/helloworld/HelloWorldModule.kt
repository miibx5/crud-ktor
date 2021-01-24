/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:57:49
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.helloworld

import br.com.edersystems.crudktor.core.helloworld.HelloWorldService
import br.com.edersystems.crudktor.core.helloworld.ports.HelloWorldRepository
import br.com.edersystems.crudktor.infrastructure.helloworld.HelloWorldRepositoryAdapter
import org.koin.dsl.module

val helloWorldModule = module {
    single { HelloWorldController(get()) }
    single { HelloWorldService(get()) }
    single<HelloWorldRepository> { HelloWorldRepositoryAdapter() }
}