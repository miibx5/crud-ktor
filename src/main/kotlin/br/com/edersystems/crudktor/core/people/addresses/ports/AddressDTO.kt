/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:05:56
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.ports

import br.com.edersystems.crudktor.core.people.addresses.domain.AddressType
import br.com.edersystems.crudktor.core.people.addresses.domain.Country
import br.com.edersystems.crudktor.core.people.addresses.domain.PublicPlace
import br.com.edersystems.crudktor.core.people.addresses.domain.StateOfCountry

class AddressDTO(
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
}