/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 20:01:45
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.infrastructure.people

import br.com.edersystems.crudktor.config.integration.DatabaseIntegrationTest
import br.com.edersystems.crudktor.objectmothers.PersonObjectMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(DatabaseIntegrationTest::class)
class PeopleRepositoryAdapterTest {

    private val repository = PeopleRepositoryAdapter()

    @Test
    fun `test create person with success`() {

        val newPerson = PersonObjectMother.new()

        val personSaved = repository.create(newPerson)

        assertThat(personSaved).isEqualTo(newPerson)
    }
}