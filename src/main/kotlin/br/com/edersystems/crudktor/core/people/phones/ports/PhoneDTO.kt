/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:49:34
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.phones.ports

import br.com.edersystems.crudktor.core.people.phones.domain.PhoneType

class PhoneDTO(
    val ddd: String,
    val ddi: String,
    val number: String,
    val type: PhoneType
)