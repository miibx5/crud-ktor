/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:11:25
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.documents.domain

import br.com.edersystems.crudktor.core.exceptions.DocumentTypeNotFoundException

enum class DocumentType {
    CPF, RG;

    companion object {
        fun of(type: String): DocumentType {
            return DocumentType.values()
                .find { it.name == type }
                ?: throw DocumentTypeNotFoundException(type)

        }
    }
}