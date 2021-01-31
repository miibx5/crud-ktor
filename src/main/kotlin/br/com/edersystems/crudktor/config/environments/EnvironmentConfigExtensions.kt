/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:13:31
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.environments

import com.typesafe.config.ConfigFactory
import io.ktor.config.HoconApplicationConfig

val environmentsConfig = HoconApplicationConfig(ConfigFactory.load())

val databaseName = environmentsConfig.property("database.name").getString()

val dbPassword = environmentsConfig.property("database.password").getString()

val dbUrl = environmentsConfig.property("database.url").getString()

val dbUser = environmentsConfig.property("database.username").getString()

val serverPort = environmentsConfig.property("server.port").getString().toInt()

val baseUrl = "http://127.0.0.1:${serverPort}"