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

import br.com.edersystems.crudktor.config.environments.getDatabase
import br.com.edersystems.crudktor.config.environments.getDatabasePassword
import br.com.edersystems.crudktor.config.environments.getDatabaseUser
import java.sql.DriverManager
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.wait.strategy.Wait

object PostgresContainer {

    internal class Container(imageName: String) : FixedHostPortGenericContainer<Container>(imageName)
    // internal class Container(imageName: String) : PostgreSQLContainer<Container>(imageName)


    private val postgresDB = getDatabase()
    private val postgresUser = getDatabaseUser()
    private val postgresPassword = getDatabasePassword()

    private val container by lazy {
        Container("postgres:12-alpine")
            .withFixedExposedPort(5434, 5432)
            .withEnv("POSTGRES_DB", postgresDB)
            .withEnv("POSTGRES_USER", postgresUser)
            .withEnv("POSTGRES_PASSWORD", postgresPassword)
            .withCommand("-c max_connections=200")
            .waitingFor(Wait.forLogMessage(".*database system is ready to accept connections.*\\n", 1))

    }

    private var isRunning = false

    fun start() {
        if (isRunning.not()) {
            println("Starting Postgres Container...")

            container.start()
            waitingTillPostgresIsReady()

            isRunning = true
        }
        else {
            println("Postgres wasn't started because it is already running")
        }
    }

    fun stop() {
        if (isRunning) {
            println("Stopping Postgres...")

            container.stop()
            isRunning = false
        }
        else {
            println("Postgres wasn't stopped because it is not running")
        }
    }

    private fun waitingTillPostgresIsReady() {
        val jdbcUrl = "jdbc:postgresql://localhost:5434/$postgresDB"
        var connected = false

        while (!connected) {
            runCatching { DriverManager.getConnection(jdbcUrl, postgresUser, postgresPassword) }
                .onSuccess {
                    connected = true
                    it.close()
                }

            Thread.sleep(100)
        }
    }

}