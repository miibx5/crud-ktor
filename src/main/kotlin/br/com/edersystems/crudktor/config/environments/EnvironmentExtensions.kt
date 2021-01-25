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

fun getEnvironments() = HoconApplicationConfig(ConfigFactory.load())

fun getDatabase() = getEnvironments().property("database.name").getString()

fun getDatabasePassword() = getEnvironments().property("database.password").getString()

fun getDatabaseUrl() = getEnvironments().property("database.url").getString()

fun getDatabaseUser() = getEnvironments().property("database.username").getString()

fun getServerPort() = getEnvironments().property("server.port").getString().toInt()


