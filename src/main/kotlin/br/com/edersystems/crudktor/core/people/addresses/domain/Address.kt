/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:47:45
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.domain

import br.com.edersystems.crudktor.commons.extensions.getOnlyNumbers
import br.com.edersystems.crudktor.core.people.addresses.ports.AddressDTO
import br.com.edersystems.crudktor.core.people.domain.Person
import java.time.LocalDateTime
import java.util.UUID

data class Address(
    val publicPlace: PublicPlace,
    val address: String,
    val neighborhood: String,
    val number: Int,
    val county: String,
    val state: StateOfCountry,
    val country: Country,
    val postalCode: String,
    val type: AddressType
) {
    var id: UUID? = null
    var owner: Person? = null
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null

    fun addOwner(ownerToAdd: Person) {
        owner = ownerToAdd
    }

    companion object {
        fun create(addressDTO: AddressDTO) = Address(
            addressDTO.publicPlace,
            addressDTO.address,
            addressDTO.neighborhood,
            addressDTO.number,
            addressDTO.county,
            addressDTO.state,
            addressDTO.country,
            addressDTO.postalCode.getOnlyNumbers(),
            addressDTO.type
        )
    }
}