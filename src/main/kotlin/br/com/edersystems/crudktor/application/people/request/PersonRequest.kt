/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:03:33
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.request

import br.com.edersystems.crudktor.core.people.domain.Gender
import br.com.edersystems.crudktor.core.people.domain.PersonType
import br.com.edersystems.crudktor.core.people.ports.dto.PersonDTO
import java.time.LocalDate

data class PersonRequest(
    val birthDate: LocalDate,
    val email: String,
    val gender: String,
    val firstName: String,
    val lastName: String,
    val addresses: List<AddressRequest>,
    val documents: List<DocumentRequest>,
    val phones: List<PhoneRequest>,
    val type: String,
) {

    fun toPersonDTO() = PersonDTO(
        birthDate = birthDate,
        email = email,
        gender = Gender.of(gender),
        firstName = firstName,
        lastName = lastName,
        addresses = addresses.map { addressRequest -> addressRequest.toAddressDTO() },
        documents = documents.map { documentRequest -> documentRequest.toDocumentDTO() },
        phones = phones.map { phoneRequest -> phoneRequest.toPhoneDTO() },
        type = PersonType.of(type)
    )
}
