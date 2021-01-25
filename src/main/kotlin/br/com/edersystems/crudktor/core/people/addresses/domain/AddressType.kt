/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:53:23
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.domain

import br.com.edersystems.crudktor.core.exceptions.TypeAddressNotFoundException

enum class AddressType {
    COMMERCIAL, RESIDENTIAL;

    companion object {
        fun of(type: String): AddressType {
            return AddressType.values()
                .find { it.name == type }
                ?: throw TypeAddressNotFoundException(type)

        }
    }
}