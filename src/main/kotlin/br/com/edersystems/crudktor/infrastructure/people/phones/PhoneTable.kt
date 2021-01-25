/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:59:48
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.infrastructure.people.phones

import br.com.edersystems.crudktor.core.people.phones.domain.Phone
import br.com.edersystems.crudktor.core.people.phones.domain.PhoneType
import br.com.edersystems.crudktor.infrastructure.people.PeopleTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime

object PhoneTable : Table("phones") {
    val id = uuid("id").autoGenerate()
    val ownerId = uuid("owner_id").uniqueIndex().references(PeopleTable.id)
    val ddd = varchar("ddd", 3)
    val ddi = varchar("ddi", 3)
    val number = varchar("number", 9)
    val type = enumerationByName("type", 30, PhoneType::class)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")

    override val primaryKey = PrimaryKey(id, name = "PK_PHONE_ID")

    fun toPhone(resultRow: ResultRow) = Phone(
        ddd = resultRow[ddd],
        ddi = resultRow[ddi],
        number = resultRow[number],
        type = resultRow[type]
    ).apply {
        id = resultRow[PhoneTable.id]
        createdAt = resultRow[PhoneTable.createdAt]
        updatedAt = resultRow[PhoneTable.updatedAt]
    }
}
