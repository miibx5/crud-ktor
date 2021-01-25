/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 16:59:56
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.ports

import br.com.edersystems.crudktor.core.people.domain.Person
import java.util.UUID

interface PeopleRepository {

    fun create(person: Person): Person

    fun findById(personId: UUID): Person?
}