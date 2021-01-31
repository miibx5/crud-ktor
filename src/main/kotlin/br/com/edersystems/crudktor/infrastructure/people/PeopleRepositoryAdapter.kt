package br.com.edersystems.crudktor.infrastructure.people

import br.com.edersystems.crudktor.core.people.addresses.domain.Address
import br.com.edersystems.crudktor.core.people.documents.domain.Document
import br.com.edersystems.crudktor.core.people.domain.Person
import br.com.edersystems.crudktor.core.people.phones.domain.Phone
import br.com.edersystems.crudktor.core.people.ports.PeopleRepository
import br.com.edersystems.crudktor.infrastructure.people.addresses.AddressTable
import br.com.edersystems.crudktor.infrastructure.people.documents.DocumentTable
import br.com.edersystems.crudktor.infrastructure.people.phones.PhoneTable
import java.time.LocalDateTime
import java.util.UUID
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class PeopleRepositoryAdapter : PeopleRepository {

    override fun create(person: Person): Person {
        person.createdAt = LocalDateTime.now()
        person.updatedAt = person.createdAt
        transaction {
            PeopleTable.insert { fillPersonColumns(it, person) }
            val lastPerson = getLastInsertedPerson()
            person.apply { id = lastPerson.id }
            person.addresses.forEach {
                it.addOwner(lastPerson)
                insertAddress(it)
            }
            person.documents.forEach {
                it.addOwner(lastPerson)
                insertDocument(it)
            }
            person.phones.forEach {
                it.addOwner(lastPerson)
                insertPhone(it)
            }
        }
        return person
    }

    // TODO: pesquisar como trabalhar com o resultRow para aproveitar os left's joins e não precisar fazer uma busca externa
    override fun findById(personId: UUID): Person? {
        return transaction {
            PeopleTable
                .leftJoin(AddressTable)
                .leftJoin(DocumentTable)
                .leftJoin(PhoneTable)
                .select { PeopleTable.id eq personId }
                .map { PeopleTable.toPerson(it) }
                .firstOrNull()
                ?.apply {
                    this.id?.let {
                        getAddressesByOwner(it).forEach { address ->
                            address.addOwner(this)
                            this.addAddress(address)
                        }

                        getDocumentsByOwner(it).forEach { document ->
                            document.addOwner(this)
                            this.addDocument(document)
                        }

                        getPhonesByOwner(it).forEach { phone ->
                            phone.addOwner(this)
                            this.addPhone(phone)
                        }
                    }
                }
        }
    }

    private fun fillPersonColumns(statement: UpdateBuilder<Number>, person: Person) {
        statement[PeopleTable.active] = person.active
        statement[PeopleTable.birthDate] = person.birthDate
        statement[PeopleTable.gender] = person.gender
        statement[PeopleTable.email] = person.email
        statement[PeopleTable.firstName] = person.firstName
        statement[PeopleTable.lastName] = person.lastName
        statement[PeopleTable.type] = person.type
        statement[PeopleTable.createdAt] = person.createdAt!!
        statement[PeopleTable.updatedAt] = person.updatedAt!!
    }

    private fun getLastInsertedPerson(): Person {
        return transaction {
            PeopleTable
                .selectAll()
                .orderBy(PeopleTable.createdAt, SortOrder.DESC)
                .map { PeopleTable.toPerson(it) }
                .first()
        }
    }

    private fun fillAddressColumns(statement: UpdateBuilder<Number>, address: Address) {
        statement[AddressTable.ownerId] = address.owner!!.id!!
        statement[AddressTable.address] = address.address
        statement[AddressTable.publicPlace] = address.publicPlace
        statement[AddressTable.neighborhood] = address.neighborhood
        statement[AddressTable.number] = address.number
        statement[AddressTable.county] = address.county
        statement[AddressTable.country] = address.country
        statement[AddressTable.postalCode] = address.postalCode
        statement[AddressTable.state] = address.state
        statement[AddressTable.type] = address.type
        statement[AddressTable.createdAt] = address.createdAt!!
        statement[AddressTable.updatedAt] = address.updatedAt!!
    }

    private fun getAddressesByOwner(ownerId: UUID): List<Address> {
        return transaction {
            AddressTable.select { AddressTable.ownerId eq ownerId }.map { AddressTable.toAddress(it) }
        }
    }

    private fun insertAddress(address: Address): Address {
        address.createdAt = LocalDateTime.now()
        address.updatedAt = address.createdAt
        transaction {
            AddressTable.insert { fillAddressColumns(it, address) }
            address.apply { id = getLastInsertedAddress().id }
        }
        return address
    }

    private fun getLastInsertedAddress(): Address {
        return transaction {
            AddressTable
                .selectAll()
                .orderBy(AddressTable.createdAt, SortOrder.DESC)
                .map { AddressTable.toAddress(it) }
                .first()
                .apply { owner?.addAddress(this) }
        }
    }

    private fun updateAddresses(address: Address) {
        address.updatedAt = LocalDateTime.now()
        transaction {
            AddressTable.update({ AddressTable.id eq address.id!! }) { fillAddressColumns(it, address) }
        }
    }

    private fun fillDocumentColumns(statement: UpdateBuilder<Number>, document: Document) {
        statement[DocumentTable.ownerId] = document.owner!!.id!!
        statement[DocumentTable.type] = document.type
        statement[DocumentTable.number] = document.number
        statement[DocumentTable.createdAt] = document.createdAt!!
        statement[DocumentTable.updatedAt] = document.updatedAt!!
    }

    private fun getDocumentsByOwner(ownerId: UUID): List<Document> {
        return transaction {
            DocumentTable.select { DocumentTable.ownerId eq ownerId }.map { DocumentTable.toDocument(it) }
        }
    }

    private fun insertDocument(document: Document): Document {
        document.createdAt = LocalDateTime.now()
        document.updatedAt = document.createdAt
        transaction {
            DocumentTable.insert { fillDocumentColumns(it, document) }
            document.apply { id = getLastInsertedDocument().id }
        }
        return document
    }

    private fun getLastInsertedDocument(): Document {
        return transaction {
            DocumentTable
                .selectAll()
                .orderBy(DocumentTable.createdAt, SortOrder.DESC)
                .map { DocumentTable.toDocument(it) }
                .first()
                .apply { owner?.addDocument(this) }
        }
    }

    private fun updateDocument(document: Document) {
        document.updatedAt = LocalDateTime.now()
        transaction {
            DocumentTable.update({ DocumentTable.id eq document.id!! }) { fillDocumentColumns(it, document) }
        }
    }

    private fun fillPhoneColumns(statement: UpdateBuilder<Number>, phone: Phone) {
        statement[PhoneTable.ownerId] = phone.owner!!.id!!
        statement[PhoneTable.ddd] = phone.ddd
        statement[PhoneTable.ddi] = phone.ddi
        statement[PhoneTable.number] = phone.number
        statement[PhoneTable.type] = phone.type
        statement[PhoneTable.createdAt] = phone.createdAt!!
        statement[PhoneTable.updatedAt] = phone.updatedAt!!
    }

    private fun getPhonesByOwner(ownerId: UUID): List<Phone> {
        return transaction {
            PhoneTable.select { PhoneTable.ownerId eq ownerId }.map { PhoneTable.toPhone(it) }
        }
    }

    private fun insertPhone(phone: Phone): Phone {
        phone.createdAt = LocalDateTime.now()
        phone.updatedAt = phone.createdAt
        transaction {
            PhoneTable.insert { fillPhoneColumns(it, phone) }
            phone.apply { id = getLastInsertedPhone().id }
        }
        return phone
    }

    private fun getLastInsertedPhone(): Phone {
        return transaction {
            PhoneTable
                .selectAll()
                .orderBy(PhoneTable.createdAt, SortOrder.DESC)
                .map { PhoneTable.toPhone(it) }
                .first()
                .apply { owner?.addPhone(this) }
        }
    }

    private fun updatePhone(phone: Phone) {
        phone.updatedAt = LocalDateTime.now()
        transaction {
            PhoneTable.update({ PhoneTable.id eq phone.id!! }) { fillPhoneColumns(it, phone) }
        }
    }
}