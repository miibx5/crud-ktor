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
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.UUID

data class PersonResponse private constructor(
    @JsonProperty("id")
    private val id: UUID,
    @JsonProperty("active")
    private val active: Boolean,
    @JsonProperty("birth_date")
    private val birthDate: LocalDate,
    @JsonProperty("email")
    private val email: String,
    @JsonProperty("gender")
    private val gender: String,
    @JsonProperty("first_name")
    private val firstName: String,
    @JsonProperty("last_name")
    private val lastName: String,
    @JsonProperty("addresses")
    private val addresses: List<AddressResponse>,
    @JsonProperty("documents")
    private val documents: List<DocumentResponse>,
    @JsonProperty("phones")
    private val phones: List<PhoneResponse>,
    @JsonProperty("type")
    private val type: String
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