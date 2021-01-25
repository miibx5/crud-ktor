/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:56:21
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.objectmothers

import br.com.edersystems.crudktor.core.people.addresses.domain.Address
import br.com.edersystems.crudktor.core.people.addresses.domain.AddressType
import br.com.edersystems.crudktor.core.people.addresses.domain.Country
import br.com.edersystems.crudktor.core.people.addresses.domain.PublicPlace
import br.com.edersystems.crudktor.core.people.addresses.domain.StateOfCountry

object AddressObjectMother {
    fun residential(
        publicPlace: PublicPlace = PublicPlace.STREET,
        address: String = "Elias Acras",
        neighborhood: String = "Jardim Celeste",
        number: Int = 494,
        county: String = "São Paulo",
        state: StateOfCountry = StateOfCountry.SP,
        country: Country = Country.BRAZIL,
        postalCode: String = "05527060",
        type: AddressType = AddressType.RESIDENTIAL
    ) = Address(
        publicPlace = publicPlace,
        address = address,
        neighborhood = neighborhood,
        number = number,
        county = county,
        state = state,
        country = country,
        postalCode = postalCode,
        type = type
    )

    fun commercial(
        publicPlace: PublicPlace = PublicPlace.AVENUE,
        address: String = "Armando Frederico Renganeschi",
        neighborhood: String = "Jardim Cristina",
        number: Int = 102,
        county: String = "Campinas",
        state: StateOfCountry = StateOfCountry.SP,
        country: Country = Country.BRAZIL,
        postalCode: String = "13054000",
        type: AddressType = AddressType.COMMERCIAL
    ) = Address(
        publicPlace,
        address,
        neighborhood,
        number,
        county,
        state,
        country,
        postalCode,
        type
    )
}