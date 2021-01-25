/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:48:12
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.integration

import br.com.edersystems.crudktor.commons.providers.DataSourceProvider
import br.com.edersystems.crudktor.config.containers.PostgresContainer
import br.com.edersystems.crudktor.config.environments.getDatabasePassword
import br.com.edersystems.crudktor.config.environments.getDatabaseUrl
import br.com.edersystems.crudktor.config.environments.getDatabaseUser
import br.com.edersystems.crudktor.config.util.DatabaseTestUtils
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource

class DatabaseIntegrationTest : BeforeAllCallback, CloseableResource, BeforeEachCallback {

    private val jdbcUrl = getDatabaseUrl()
    private val databasePassword = getDatabasePassword()
    private val databaseUsername = getDatabaseUser()

    private val dataSource by lazy { DataSourceProvider.provide(jdbcUrl, databaseUsername, databasePassword) }
    private val databaseTestUtils by lazy { DatabaseTestUtils(jdbcUrl, databaseUsername, databasePassword) }

    override fun beforeAll(context: ExtensionContext?) {
        PostgresContainer.start()
        Database.connect(dataSource)
        Flyway.configure().dataSource(dataSource).load().clean()
        Flyway.configure().dataSource(dataSource).load().migrate()
        databaseTestUtils.cleanAllTables()
    }

    override fun close() {
        PostgresContainer.stop()
    }

    override fun beforeEach(context: ExtensionContext?) {
        databaseTestUtils.cleanAllTables()
    }
}