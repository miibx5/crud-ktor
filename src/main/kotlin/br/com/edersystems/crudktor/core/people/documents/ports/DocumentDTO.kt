/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:48:45
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.documents.ports

import br.com.edersystems.crudktor.core.people.documents.domain.DocumentType

class DocumentDTO(
    val number: String,
    val type: DocumentType
)