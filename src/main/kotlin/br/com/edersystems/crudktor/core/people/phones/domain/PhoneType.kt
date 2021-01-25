/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:14:18
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.phones.domain

import br.com.edersystems.crudktor.core.exceptions.PhoneTypeNotFoundException

enum class PhoneType {
    COMMERCIAL, MESSAGE, MOBILE, RESIDENTIAL;

    companion object {
        fun of(phoneType: String): PhoneType {
            return values()
                .find { it.name == phoneType }
                ?: throw (PhoneTypeNotFoundException(phoneType))

        }
    }
}