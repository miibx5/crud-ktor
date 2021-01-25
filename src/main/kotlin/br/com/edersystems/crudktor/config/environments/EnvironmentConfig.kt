/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:46:50
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.environments

import com.typesafe.config.Config

class EnvironmentConfig(config: Config) {

    val databaseUrl: String = config.getString("database.url")
    val databaseUser: String = config.getString("database.username")
    val databasePassword: String = config.getString("database.password")
    val serverPort: Int = config.getInt("server.port")
}