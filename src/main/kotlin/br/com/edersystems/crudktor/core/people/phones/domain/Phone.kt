/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:49:53
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.phones.domain

import br.com.edersystems.crudktor.commons.extensions.getOnlyNumbers
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.core.people.phones.ports.PhoneDTO
import java.time.LocalDateTime
import java.util.UUID

data class Phone(
    val ddd: String,
    val ddi: String,
    val number: String,
    val type: PhoneType
) {
    var id: UUID? = null
    var owner: Person? = null
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null

    fun addOwner(ownerToAdd: Person) {
        owner = ownerToAdd
    }

    companion object {
        fun create(phoneDTO: PhoneDTO) = Phone(
            phoneDTO.ddd.getOnlyNumbers(),
            phoneDTO.ddi.getOnlyNumbers(),
            phoneDTO.number.getOnlyNumbers(),
            phoneDTO.type
        )
    }
}