/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 15:58:06
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.helloworld

import br.com.edersystems.crudktor.application.exceptions.ContentType
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.accept
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.helloWorldRouter(controller: HelloWorldController) {
    accept(ContentType.json) {
        route("/hello") {
            get { return@get controller.getHelloWorld(call) }
        }
    }
}