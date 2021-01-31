/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:28:44
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.containers

import br.com.edersystems.crudktor.config.environments.databaseName
import br.com.edersystems.crudktor.config.environments.dbPassword
import br.com.edersystems.crudktor.config.environments.dbUrl
import br.com.edersystems.crudktor.config.environments.dbUser
import java.sql.DriverManager
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.wait.strategy.Wait

object PostgresContainer {

    internal class Container(imageName: String) : FixedHostPortGenericContainer<Container>(imageName)
    // internal class Container(imageName: String) : PostgreSQLContainer<Container>(imageName)

    private val database = databaseName
    private val databaseUrl = dbUrl
    private val databaseUser = dbUser
    private val databasePassword = dbPassword

    private val container by lazy {
        Container("postgres:11-alpine")
            .withFixedExposedPort(5434, 5432)
            .withEnv("POSTGRES_DB", database)
            .withEnv("POSTGRES_USER", databaseUser)
            .withEnv("POSTGRES_PASSWORD", databasePassword)
            .waitingFor(Wait.forLogMessage(".*database system is ready to accept connections.*\\n", 1))

    }

    private var isRunning = false

    fun start() {
        if (isRunning.not()) {
            println("Starting Postgres Container...")

            container.start()
            waitingTillPostgresIsReady()

            isRunning = true
        } else {
            println("Postgres wasn't started because it is already running")
        }
    }

    fun stop() {
        if (isRunning) {
            println("Stopping Postgres...")

            container.stop()
            isRunning = false
        } else {
            println("Postgres wasn't stopped because it is not running")
        }
    }

    private fun waitingTillPostgresIsReady() {
        var connected = false

        while (!connected) {
            runCatching { DriverManager.getConnection(databaseUrl, databaseUser, databasePassword) }
                .onSuccess {
                    connected = true
                    it.close()
                }

            Thread.sleep(100)
        }
    }

}