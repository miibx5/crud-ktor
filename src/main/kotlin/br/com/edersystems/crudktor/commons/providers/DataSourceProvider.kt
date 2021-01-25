/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 16:52:26
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.providers

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.util.Properties

object DataSourceProvider {

    fun provide(databaseUrl: String, databaseUser: String, databasePassword: String): HikariDataSource {

        val config = HikariConfig(configuration(databaseUrl, databaseUser, databasePassword))

        return HikariDataSource(config)
    }

    private fun configuration(databaseUrl: String, databaseUser: String, databasePassword: String) =
        Properties().apply {
            put("jdbcUrl", databaseUrl)
            put("maximumPoolSize", 50)
            put("dataSource.user", databaseUser)
            put("dataSource.password", databasePassword)
            put("driverClassName", "org.postgresql.Driver")
        }
}