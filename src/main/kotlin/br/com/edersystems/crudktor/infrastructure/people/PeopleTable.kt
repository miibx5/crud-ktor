/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:36:11
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.infrastructure.people

import br.com.edersystems.crudktor.core.people.domain.Gender
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.core.people.domain.PersonType
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.date
import org.jetbrains.exposed.sql.`java-time`.datetime

object PeopleTable : Table("people") {

    val id = uuid("id")
    val active = bool("active")
    val birthDate = date("birth_date")
    val email = varchar("email", 70)
    val gender = enumerationByName("gender", 10, Gender::class)
    val firstName = varchar("first_name", 100)
    val lastName = varchar("last_name", 50)
    val type = enumerationByName("type", 20, PersonType::class)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")

    override val primaryKey = PrimaryKey(id, name = "PK_PERSON_ID")

    fun toPerson(resultRow: ResultRow) = Person(
        active = resultRow[active],
        birthDate = resultRow[birthDate],
        email = resultRow[email],
        gender = resultRow[gender],
        firstName = resultRow[firstName],
        lastName = resultRow[lastName],
        type = resultRow[type]
    ).apply {
        id = resultRow[PeopleTable.id]
        createdAt = resultRow[PeopleTable.createdAt]
        updatedAt = resultRow[PeopleTable.updatedAt]
    }
}