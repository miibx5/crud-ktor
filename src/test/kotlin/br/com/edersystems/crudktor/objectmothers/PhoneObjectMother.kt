/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:54:10
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.objectmothers

import br.com.edersystems.crudktor.core.people.phones.domain.Phone
import br.com.edersystems.crudktor.core.people.phones.domain.PhoneType

object PhoneObjectMother {
    fun mobile(
        ddd: String = "11",
        ddi: String = "55",
        number: String = "98169-2535",
        type: PhoneType = PhoneType.MOBILE
    ) = Phone(ddd, ddi, number, type)

    fun residential(
        ddd: String = "11",
        ddi: String = "55",
        number: String = "3839-9905",
        type: PhoneType = PhoneType.RESIDENTIAL
    ) = Phone(ddd, ddi, number, type)
}