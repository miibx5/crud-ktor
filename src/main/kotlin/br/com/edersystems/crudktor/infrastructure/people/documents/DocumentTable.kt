/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:58:38
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.infrastructure.people.documents

import br.com.edersystems.crudktor.core.people.documents.domain.Document
import br.com.edersystems.crudktor.core.people.documents.domain.DocumentType
import br.com.edersystems.crudktor.infrastructure.people.PeopleTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime

object DocumentTable : Table("documents") {

    val id = uuid("id").autoGenerate()
    val ownerId = uuid("owner_id").uniqueIndex().references(PeopleTable.id)
    val number = varchar("number", 20)
    val type = enumerationByName("type", 30, DocumentType::class)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")

    override val primaryKey = PrimaryKey(id, name = "PK_DOCUMENT_ID")

    fun toDocument(resultRow: ResultRow) = Document(
        number = resultRow[number],
        type = resultRow[type]
    ).apply {
        id = resultRow[DocumentTable.id]
        createdAt = resultRow[DocumentTable.createdAt]
        updatedAt = resultRow[DocumentTable.updatedAt]
    }
}
