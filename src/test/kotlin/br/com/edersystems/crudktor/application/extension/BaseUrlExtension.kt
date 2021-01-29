/*
Project .....................: crud-ktor-app
Creation Date ...............: 28/01/2021 19:31:35
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.application.extension

import br.com.edersystems.crudktor.config.environments.getServerPort

val baseUrl = "http://127.0.0.1:${getServerPort()}"