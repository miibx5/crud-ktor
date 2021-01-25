/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 16:58:06
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.people

import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.peopleRouter(controller: PeopleController) {
    route("/person") {
        post {
            controller.create(call)
        }
    }
}