/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:04:50
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.response

import br.com.edersystems.crudktor.core.people.domain.Person
import java.time.LocalDate
import java.util.UUID

data class PersonResponse private constructor(
    val id: UUID,
    val active: Boolean,
    val birthDate: LocalDate,
    val email: String,
    val gender: String,
    val firstName: String,
    val lastName: String,
    val addresses: List<AddressResponse>,
    val documents: List<DocumentResponse>,
    val phones: List<PhoneResponse>,
    val type: String
) {
    companion object {
        fun create(person: Person) = PersonResponse(
            id = person.id!!,
            active = person.active,
            birthDate = person.birthDate,
            email = person.email,
            gender = person.gender.name,
            firstName = person.firstName,
            lastName = person.lastName,
            addresses = person.addresses.map { address -> AddressResponse.create(address) },
            documents = person.documents.map { document -> DocumentResponse.create(document) },
            phones = person.phones.map { phone -> PhoneResponse.create(phone) },
            type = person.type.name
        )
    }
}