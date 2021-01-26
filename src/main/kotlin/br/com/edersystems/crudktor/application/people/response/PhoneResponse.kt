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
import com.fasterxml.jackson.annotation.JsonProperty


data class PhoneResponse private constructor(
    @JsonProperty("ddd")
    val ddd: String,
    @JsonProperty("ddi")
    val ddi: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("type")
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
