/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:58:49
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.addresses.domain

import br.com.edersystems.crudktor.core.exceptions.StateNotFoundException

enum class StateOfCountry {
    AM, BA, PA, SP;

    companion object {
        fun of(state: String): StateOfCountry {
            return StateOfCountry.values()
                .find { it.name == state }
                ?: throw StateNotFoundException(state)

        }
    }
}