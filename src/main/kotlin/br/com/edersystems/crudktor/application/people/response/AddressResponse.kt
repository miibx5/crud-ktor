/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:33:11
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.response

import br.com.edersystems.crudktor.core.people.addresses.domain.Address

data class AddressResponse private constructor(
    val publicPlace: String,
    val address: String,
    val neighborhood: String,
    val number: Int,
    val county: String,
    val state: String,
    val country: String,
    val postalCode: String,
    val type: String
) {
    companion object {
        fun create(address: Address) = AddressResponse(
            publicPlace = address.publicPlace.name,
            address = address.address,
            neighborhood = address.neighborhood,
            number = address.number,
            county = address.county,
            state = address.state.name,
            country = address.country.name,
            postalCode = address.postalCode,
            type = address.type.name
        )
    }
}