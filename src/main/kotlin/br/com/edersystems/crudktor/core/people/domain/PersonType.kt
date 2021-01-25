/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 17:32:25
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.core.people.domain

import br.com.edersystems.crudktor.core.exceptions.PersonTypeNotFoundException

enum class PersonType {
    LEGAL_PERSON, PHYSICAL;

    companion object {
        fun of(type: String): PersonType {
            return PersonType.values()
                .find { it.name == type }
                ?: throw PersonTypeNotFoundException(type)

        }
    }
}


/*

class AssetNotFoundException(
    private val asset: String
) : DigitalAccountException() {

    override val message = "Asset $asset not found"

    override fun response() = ErrorResponse.create(message, code).addDetail("asset", asset)

    override fun statusCode() = HttpStatusCode.NotFound
}

 */