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
    private val publicPlace: String,
    private val address: String,
    private val neighborhood: String,
    private val number: Int,
    private val county: String,
    private val state: String,
    private val country: String,
    private val postalCode: String,
    private val type: String
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