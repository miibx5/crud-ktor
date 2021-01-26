package br.com.edersystems.crudktor.core.exceptions

import br.com.edersystems.crudktor.commons.exceptions.CrudKtorException
import br.com.edersystems.crudktor.commons.exceptions.error.ErrorResponseOrchestrator
import io.ktor.http.HttpStatusCode
import java.util.UUID

class PersonNotFoundException(private val personId: UUID) : CrudKtorException() {

    override val message = "Person $personId not found"

    override fun response() = ErrorResponseOrchestrator
        .createError(HttpStatusCode.BadRequest.value.toString(), message)

    override fun status() = HttpStatusCode.NotFound
}
