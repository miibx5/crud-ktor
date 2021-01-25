/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:54:49
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.objectmothers

import br.com.edersystems.crudktor.core.people.domain.Gender
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.core.people.domain.PersonType
import java.time.LocalDate

object PersonObjectMother {
    fun new(
        active: Boolean = true,
        birthDate: LocalDate = LocalDate.of(1991, 7, 5),
        email: String = "leticiaisabellybaptista__leticiaisabellybaptista@aulicinobastos.com.br",
        gender: Gender = Gender.FEMALE,
        firstName: String = "Letícia Isabelly",
        lastName: String = "Baptista",
        type: PersonType = PersonType.PHYSICAL
    ) = Person(
        active = active,
        birthDate = birthDate,
        email = email,
        gender = gender,
        firstName = firstName,
        lastName = lastName,
        type = type
    )

    fun personWithAddress() = new().apply { apply { addAddress(AddressObjectMother.residential()) } }
}