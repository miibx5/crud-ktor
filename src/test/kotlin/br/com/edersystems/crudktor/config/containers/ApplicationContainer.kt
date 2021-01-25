/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 19:11:47
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.containers

import br.com.edersystems.crudktor.CrudKtorApplication
import br.com.edersystems.crudktor.config.environments.getServerPort
import io.ktor.server.netty.NettyApplicationEngine

object ApplicationContainer {

    private lateinit var server: NettyApplicationEngine
    private var isRunning = false

    fun start() {
        if (isRunning.not()) {
            println("Starting application...")


            server = CrudKtorApplication.start(getServerPort())
            isRunning = true
        }
        else {
            println("Application wasn't started because it is already running")
        }
    }

    fun stop() {
        if (isRunning) {
            println("Stopping application...")
            server.stop(5, 10)
            isRunning = false
        }
        else {
            println("Application wasn't stopped because it is not running")
        }
    }
}