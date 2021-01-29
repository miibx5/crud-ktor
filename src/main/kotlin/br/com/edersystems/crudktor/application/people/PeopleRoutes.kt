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

import br.com.edersystems.crudktor.application.exceptions.ContentType
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.accept
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.peopleRouter(controller: PeopleController) {
    accept(ContentType.json) {
        route("/person") {
            get("/{id}") {
                return@get controller.getById(call)
            }
            post {
                return@post controller.create(call)
            }
        }
    }
}