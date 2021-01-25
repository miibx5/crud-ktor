/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 16:57:22
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people

import br.com.edersystems.crudktor.core.people.PeopleService
import br.com.edersystems.crudktor.core.people.ports.PeopleRepository
import br.com.edersystems.crudktor.infrastructure.people.PeopleRepositoryAdapter
import org.koin.dsl.module

val peopleModule = module {
    single { PeopleController(get(), get()) }
    single { PeopleService(get()) }
    single<PeopleRepository> { PeopleRepositoryAdapter() }
}