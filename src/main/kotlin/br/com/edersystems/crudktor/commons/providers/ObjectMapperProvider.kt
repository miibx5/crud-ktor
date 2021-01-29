/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:30:39
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.commons.providers

import br.com.edersystems.crudktor.config.jackson.localdate.LocalDateDeserializer
import br.com.edersystems.crudktor.config.jackson.localdate.LocalDateSerializer
import br.com.edersystems.crudktor.config.jackson.localdatetime.LocalDateTimeDeserializer
import br.com.edersystems.crudktor.config.jackson.localdatetime.LocalDateTimeSerializer
import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime

object ObjectMapperProvider {

    fun provide() = jacksonObjectMapper().apply {
        propertyNamingStrategy = SNAKE_CASE

        setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
            indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
            indentObjectsWith(DefaultIndenter("  ", "\n"))
        })

        registerModule(JavaTimeModule())

        val module = SimpleModule()
        module.addSerializer(BigInteger::class.java, ToStringSerializer())
        module.addSerializer(LocalDate::class.java, LocalDateSerializer())
        module.addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer())
        module.addDeserializer(LocalDate::class.java, LocalDateDeserializer())
        module.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer())

        registerModule(module)

        enable(SerializationFeature.INDENT_OUTPUT)
        enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        // enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)

        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)

        canSerialize(Boolean::class.java)

        deserializationConfig.withAppendedAnnotationIntrospector(JacksonAnnotationIntrospector())

        serializationConfig.withAppendedAnnotationIntrospector(JacksonAnnotationIntrospector())
    }
}