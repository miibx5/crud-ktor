/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:31:02
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.domain

import br.com.edersystems.crudktor.core.exceptions.GenderNotFoundException

enum class Gender {
    FEMALE, MALE;

    companion object {
        fun of(type: String): Gender {
            return Gender.values()
                .find { it.name == type }
                ?: throw GenderNotFoundException(type)

        }
    }
}