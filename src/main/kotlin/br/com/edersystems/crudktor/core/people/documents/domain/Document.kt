/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:48:20
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.documents.domain

import br.com.edersystems.crudktor.commons.extensions.getOnlyNumbers
import br.com.edersystems.crudktor.core.people.documents.ports.DocumentDTO
import br.com.edersystems.crudktor.core.people.domain.Person
import java.time.LocalDateTime
import java.util.UUID

data class Document(
    val number: String,
    val type: DocumentType
) {
    var id: UUID? = null
    var owner: Person? = null
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null

    fun addOwner(ownerToAdd: Person) {
        owner = ownerToAdd
    }

    companion object {
        fun create(documentDTO: DocumentDTO) = Document(
            documentDTO.number.getOnlyNumbers(),
            documentDTO.type
        )
    }
}