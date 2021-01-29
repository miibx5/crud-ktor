/*
Project .....................: crud-ktor-app
Creation Date ...............: 28/01/2021 18:53:50
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.client

import br.com.edersystems.crudktor.commons.extensions.json
import com.github.kittinunf.fuel.Fuel
import io.ktor.http.ContentType

object FuelHttpClientMethod {
    
    private fun getHeaders(): Map<String, String> = mapOf(
        "Content-Type" to ContentType.Application.Json.toString()
    )

    fun post(url: String, body: String = "") = Fuel
        .post(url)
        .header(this.getHeaders())
        .body(body)
        .responseString()
        .let { it.second.json to it.second.statusCode }

    fun get(url: String) = Fuel
        .get(url)
        .header(this.getHeaders())
        .responseString()
        .let { it.second.json to it.second.statusCode }

    fun patch(url: String, body: String) = Fuel
        .patch(url)
        .header(this.getHeaders())
        .body(body)
        .responseString()
        .let { it.second.json to it.second.statusCode }

    fun put(url: String, body: String) = Fuel
        .put(url)
        .header(this.getHeaders())
        .body(body)
        .responseString()
        .let { it.second.json to it.second.statusCode }
}

