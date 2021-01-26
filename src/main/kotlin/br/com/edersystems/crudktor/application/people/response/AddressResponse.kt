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
import com.fasterxml.jackson.annotation.JsonProperty

data class AddressResponse private constructor(
    @JsonProperty("public_place")
    private val publicPlace: String,
    @JsonProperty("address")
    private val address: String,
    @JsonProperty("neighborhood")
    private val neighborhood: String,
    @JsonProperty("number")
    private val number: Int,
    @JsonProperty("county")
    private val county: String,
    @JsonProperty("state")
    private val state: String,
    @JsonProperty("country")
    private val country: String,
    @JsonProperty("postal_code")
    private val postalCode: String,
    @JsonProperty("type")
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