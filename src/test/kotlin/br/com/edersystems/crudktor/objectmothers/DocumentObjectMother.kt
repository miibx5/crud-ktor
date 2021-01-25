/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:55:34
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.objectmothers

import br.com.edersystems.crudktor.core.people.documents.domain.Document
import br.com.edersystems.crudktor.core.people.documents.domain.DocumentType

object DocumentObjectMother {
    fun documentCpf(
        number: String = "31270611887",
        type: DocumentType = DocumentType.CPF,
    ) = Document(number, type)

    fun documentRg(
        number: String = "459253591",
        type: DocumentType = DocumentType.RG
    ) = Document(number, type)
}
