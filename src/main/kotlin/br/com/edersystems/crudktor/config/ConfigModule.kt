/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:44:52
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config

import br.com.edersystems.crudktor.commons.providers.DataSourceProvider
import br.com.edersystems.crudktor.commons.providers.ObjectMapperProvider
import br.com.edersystems.crudktor.config.environments.EnvironmentConfig
import com.typesafe.config.ConfigFactory
import javax.sql.DataSource
import org.koin.dsl.module

val configModule = module {
    single { EnvironmentConfig(ConfigFactory.load()) }
    single { ObjectMapperProvider.provide() }
    single<DataSource> {
        with(get<EnvironmentConfig>()) {
            DataSourceProvider.provide(databaseUrl, databaseUser, databasePassword)
        }
    }
}