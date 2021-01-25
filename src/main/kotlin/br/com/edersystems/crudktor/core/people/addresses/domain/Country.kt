/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:02:40
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.domain

import br.com.edersystems.crudktor.core.exceptions.CountryNotFoundException

enum class Country {
    BRAZIL, GERMANY, UNITED_STATE;

    companion object {
        fun of(country: String): Country {
            return Country.values()
                .find { it.name == country }
                ?: throw CountryNotFoundException(country)

        }
    }
}