/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:01:52
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.domain

import br.com.edersystems.crudktor.core.people.addresses.domain.Address
import br.com.edersystems.crudktor.core.people.documents.domain.Document
import br.com.edersystems.crudktor.core.people.phones.domain.Phone
import br.com.edersystems.crudktor.core.people.ports.dto.PersonDTO
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Person(
    val active: Boolean,
    val birthDate: LocalDate,
    val email: String,
    val gender: Gender,
    val firstName: String,
    val lastName: String,
    val type: PersonType,
) {
    var id: UUID? = null
    val addresses: MutableList<Address> = mutableListOf()
    val documents: MutableList<Document> = mutableListOf()
    val phones: MutableList<Phone> = mutableListOf()
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null


    companion object {
        fun create(personDTO: PersonDTO) = Person(
            active = true,
            birthDate = personDTO.birthDate,
            email = personDTO.email,
            gender = personDTO.gender,
            firstName = personDTO.firstName,
            lastName = personDTO.lastName,
            type = personDTO.type
        ).apply {
            personDTO.addresses.forEach { addAddress(Address.create(it)) }
            personDTO.documents.forEach { addDocument(Document.create(it)) }
            personDTO.phones.forEach { addPhone(Phone.create(it)) }
        }
    }

    fun addAddress(addressToAdd: Address) = addresses.add(addressToAdd)
    fun addDocument(documentToAdd: Document) = documents.add(documentToAdd)
    fun addPhone(phoneToAdd: Phone) = phones.add(phoneToAdd)

}
