/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:51:23
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.integration

import br.com.edersystems.crudktor.config.containers.ApplicationContainer
import br.com.edersystems.crudktor.config.containers.PostgresContainer
import br.com.edersystems.crudktor.config.environments.EnvironmentConfig
import br.com.edersystems.crudktor.config.util.DatabaseTestUtils
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource
import org.koin.test.KoinTest
import org.koin.test.get


class IntegrationTest : BeforeAllCallback, CloseableResource, BeforeEachCallback, KoinTest {

    private val databaseTestUtils by lazy {
        get<EnvironmentConfig>().run { DatabaseTestUtils(databaseUrl, databasePassword, databaseUser) }
    }

    override fun beforeAll(context: ExtensionContext?) {
        PostgresContainer.start()
        ApplicationContainer.start()
    }

    override fun close() {
        ApplicationContainer.stop()
        PostgresContainer.stop()
    }

    override fun beforeEach(context: ExtensionContext?) {
        databaseTestUtils.cleanAllTables()
    }
}