/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:31:52
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.request

import br.com.edersystems.crudktor.core.people.documents.domain.DocumentType
import br.com.edersystems.crudktor.core.people.documents.ports.DocumentDTO

data class DocumentRequest(
    val number: String,
    val type: String
) {
    fun toDocumentDTO() = DocumentDTO(
        number = number,
        type = DocumentType.of(type)
    )
}