/*
Project .....................: crud-ktor-app
Creation Date ...............: 31/01/2021 13:38:51
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.response

import br.com.edersystems.crudktor.core.people.domain.Person
import java.util.UUID

data class CreatedPersonResponse private constructor(val id: UUID) {
    companion object {
        fun create(person: Person) = CreatedPersonResponse(person.id!!)
    }
}
