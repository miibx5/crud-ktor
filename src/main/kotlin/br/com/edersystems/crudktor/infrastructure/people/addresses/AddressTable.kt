/*
Project .....................: crud-ktor-app
Creation Date ...............: 24/01/2021 18:55:52
Developer....................: luciano
Copyright....................: 2021
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2021 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.crudktor.infrastructure.people.addresses

import br.com.edersystems.crudktor.core.people.addresses.domain.Address
import br.com.edersystems.crudktor.core.people.addresses.domain.AddressType
import br.com.edersystems.crudktor.core.people.addresses.domain.Country
import br.com.edersystems.crudktor.core.people.addresses.domain.PublicPlace
import br.com.edersystems.crudktor.core.people.addresses.domain.StateOfCountry
import br.com.edersystems.crudktor.infrastructure.people.PeopleTable
import java.util.UUID
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object AddressTable : Table("addresses") {

    val id = uuid("id").autoGenerate()
    val ownerId = uuid("owner_id").uniqueIndex().references(PeopleTable.id)
    val publicPlace = enumerationByName("public_place", 30, PublicPlace::class)
    val address = varchar("address", 150)
    val neighborhood = varchar("neighborhood", 120)
    val number = integer("number")
    val county = varchar("county", 120)
    val state = enumerationByName("state", 100, StateOfCountry::class)
    val country = enumerationByName("country", 120, Country::class)
    val postalCode = varchar("postal_code", 12)
    val type = enumerationByName("type", 30, AddressType::class)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")

    override val primaryKey = PrimaryKey(id, name = "PK_ADDRESS_ID")

    fun toAddress(resultRow: ResultRow) = Address(
        publicPlace = resultRow[publicPlace],
        address = resultRow[address],
        neighborhood = resultRow[neighborhood],
        number = resultRow[number],
        county = resultRow[county],
        state = resultRow[state],
        country = resultRow[country],
        postalCode = resultRow[postalCode],
        type = resultRow[type]
    ).apply {
        id = resultRow[AddressTable.id]
        createdAt = resultRow[AddressTable.createdAt]
        updatedAt = resultRow[AddressTable.updatedAt]
    }

    fun findAllByOwnerId(ownerId: UUID): MutableList<Address> {
        return transaction {
            AddressTable
                .select { AddressTable.ownerId eq ownerId }
                .map { AddressTable.toAddress(it) }.toMutableList()
        }
    }
}