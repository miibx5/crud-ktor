/*
Project .....................: crud-ktor
Creation Date ...............: 24/01/2021 12:40:37
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.config.jackson.localdatetime

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeSerializer @JvmOverloads constructor(localDateTimeClass: Class<LocalDateTime?>? = null) :
    StdSerializer<LocalDateTime?>(localDateTimeClass) {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: LocalDateTime?, gen: JsonGenerator, arg2: SerializerProvider?) {
        gen.writeString(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value))
    }

    companion object {
        private const  val serialVersionUID = -29L
    }
}