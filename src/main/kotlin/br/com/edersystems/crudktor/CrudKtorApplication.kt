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

import br.com.edersystems.crudktor.application.helloworld.helloWorldModule
import br.com.edersystems.crudktor.application.helloworld.helloWorldRouter
import br.com.edersystems.crudktor.config.configModule
import br.com.edersystems.crudktor.config.getServerPort
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DataConversion
import io.ktor.http.ContentType
import io.ktor.jackson.JacksonConverter
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
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
            helloWorldModule
        )
        modules(modules)
    }

    install(ContentNegotiation) {
        register(ContentType.Application.Json, JacksonConverter(get()))
    }

    install(DataConversion)

    routing {
        helloWorldRouter(get())
//        install(StatusPages) {
//            exception<AuthenticationException> { cause ->
//                call.respond(HttpStatusCode.Unauthorized)
//            }
//            exception<AuthorizationException> { cause ->
//                call.respond(HttpStatusCode.Forbidden)
//            }
//        }
    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()