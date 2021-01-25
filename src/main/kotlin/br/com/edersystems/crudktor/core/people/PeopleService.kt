/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:19:05
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people

import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.core.people.ports.PeopleRepository
import br.com.edersystems.crudktor.core.people.ports.dto.PersonDTO

class PeopleService(private val repository: PeopleRepository) {

    fun create(personDTO: PersonDTO): Person {
        return repository.create(Person.create(personDTO))
    }
}