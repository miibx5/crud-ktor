/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:55:15
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.domain

import br.com.edersystems.crudktor.core.exceptions.PublicPlaceNotFoundException

enum class PublicPlace {
    AVENUE, STREET;

    companion object {
        fun of(publicPlaceValue: String): PublicPlace {
            return values()
                .find { it.name == publicPlaceValue }
                ?: throw PublicPlaceNotFoundException(publicPlaceValue)

        }
    }
}