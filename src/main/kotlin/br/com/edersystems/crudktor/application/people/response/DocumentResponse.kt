/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:33:54
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people.response

import br.com.edersystems.crudktor.core.people.documents.domain.Document

data class DocumentResponse private constructor(
    private val number: String,
    private val type: String
) {
    companion object {
        fun create(document: Document) = DocumentResponse(
            number = document.number,
            type = document.type.name
        )
    }
}