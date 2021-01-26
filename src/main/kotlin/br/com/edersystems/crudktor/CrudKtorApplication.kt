/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:23:55
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor

import br.com.edersystems.crudktor.application.exceptions.ExceptionHandler
import br.com.edersystems.crudktor.application.helloworld.helloWorldModule
import br.com.edersystems.crudktor.application.helloworld.helloWorldRouter
import br.com.edersystems.crudktor.application.people.peopleModule
import br.com.edersystems.crudktor.application.people.peopleRouter
import br.com.edersystems.crudktor.config.configModule
import br.com.edersystems.crudktor.config.environments.getServerPort
import io.ktor.application.Application
import io.ktor.application.ApplicationStarted
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.jackson.JacksonConverter
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import javax.sql.DataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.koin.core.logger.PrintLogger
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.get

fun main() {

    CrudKtorApplication.start(getServerPort())
}

object CrudKtorApplication {
    fun start(port: Int): NettyApplicationEngine {
        return embeddedServer(
            factory = Netty,
            watchPaths = listOf("src/main/kotlin/br.com.edersystems.ktorcruddemo"),
            port = port,
            module = Application::mainModule
        ).start(false)
    }
}

fun Application.mainModule(testing: Boolean = false) {

    install(Koin) {
        val modules = listOf(
            configModule,
            helloWorldModule,
            peopleModule
        )
        modules(modules)

        logger(PrintLogger())
    }

    install(ContentNegotiation) {
        register(ContentType.Application.Json, JacksonConverter(get()))
    }

    //install(StatusPages) { ExceptionHandler.handle(this) }

    routing {
        helloWorldRouter(controller = get())
        peopleRouter(controller = get())
        install(StatusPages) { ExceptionHandler.handle(this) }
    }

    environment.monitor.subscribe(ApplicationStarted) {
        startDatabase(get())
    }
}

private fun startDatabase(dataSource: DataSource) {
    Database.connect(dataSource)
    val flyway = Flyway.configure().dataSource(dataSource).load()
    flyway.clean()
    flyway.migrate()
}