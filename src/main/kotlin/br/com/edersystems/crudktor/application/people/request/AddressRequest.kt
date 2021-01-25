/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:27:16
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.request

import br.com.edersystems.crudktor.core.people.addresses.domain.AddressType
import br.com.edersystems.crudktor.core.people.addresses.domain.Country
import br.com.edersystems.crudktor.core.people.addresses.domain.PublicPlace
import br.com.edersystems.crudktor.core.people.addresses.domain.StateOfCountry
import br.com.edersystems.crudktor.core.people.addresses.ports.AddressDTO

data class AddressRequest(
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
    fun toAddressDTO() = AddressDTO(
        publicPlace = PublicPlace.of(publicPlace),
        address = address,
        neighborhood = neighborhood,
        number = number,
        county = county,
        state = StateOfCountry.of(state),
        country = Country.of(country),
        postalCode = postalCode,
        type = AddressType.of(type)
    )
}