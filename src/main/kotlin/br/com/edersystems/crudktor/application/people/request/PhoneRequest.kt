/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:30:53
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.request

import br.com.edersystems.crudktor.core.people.phones.domain.PhoneType
import br.com.edersystems.crudktor.core.people.phones.ports.PhoneDTO

data class PhoneRequest(
    val ddd: String,
    val ddi: String,
    val number: String,
    val type: String
) {
    fun toPhoneDTO() = PhoneDTO(
        ddd = ddd,
        ddi = ddi,
        number = number,
        type = PhoneType.of(type)
    )
}