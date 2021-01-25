/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:34:30
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.response

import br.com.edersystems.crudktor.core.people.phones.domain.Phone


data class PhoneResponse private constructor(
    val ddd: String,
    val ddi: String,
    val number: String,
    val type: String
) {

    companion object {
        fun create(phone: Phone) = PhoneResponse(
            ddd = phone.ddd,
            ddi = phone.ddi,
            number = phone.number,
            type = phone.type.name
        )
    }
}
