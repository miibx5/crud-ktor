/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:00:19
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.ports.dto

import br.com.edersystems.crudktor.core.people.addresses.ports.AddressDTO
import br.com.edersystems.crudktor.core.people.documents.ports.DocumentDTO
import br.com.edersystems.crudktor.core.people.domain.Gender
import br.com.edersystems.crudktor.core.people.domain.PersonType
import br.com.edersystems.crudktor.core.people.phones.ports.PhoneDTO
import java.time.LocalDate

class PersonDTO(
    val birthDate: LocalDate,
    val email: String,
    val gender: Gender,
    val firstName: String,
    val lastName: String,
    val type: PersonType,
    val addresses: List<AddressDTO>,
    val documents: List<DocumentDTO>,
    val phones: List<PhoneDTO>
)