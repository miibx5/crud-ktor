/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 13:47:21
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config

import com.typesafe.config.ConfigFactory
import io.ktor.config.HoconApplicationConfig

fun getServerPort(): Int {
    val envConfig = HoconApplicationConfig(ConfigFactory.load())
    return envConfig.property("server.port").getString().toInt()
}