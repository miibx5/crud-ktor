package br.com.edersystems.crudktor.infrastructure.helloworld

import br.com.edersystems.crudktor.core.helloworld.domain.HelloWorld
import br.com.edersystems.crudktor.core.helloworld.ports.HelloWorldRepository
import br.com.edersystems.crudktor.core.helloworld.ports.dto.HelloWorldDTO

class HelloWorldRepositoryAdapter : HelloWorldRepository {
    override fun getHelloWorld(): HelloWorld {
        return HelloWorld.create(HelloWorldDTO("HELLO WORLD!!!"))
    }
}