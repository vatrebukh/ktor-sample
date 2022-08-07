package com.vatrebukh.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import java.util.concurrent.atomic.AtomicInteger

@Serializable
data class Customer(val id: Int, var firstName: String, var lastName: String, var email: String?) {
    companion object {
        private val idCounter = AtomicInteger()

        fun newEntry(firstName: String, lastName: String, email: String?) = Customer(idCounter.getAndIncrement(), firstName, lastName, email ?: "")
    }
}

object Customers : Table() {
    val id = integer("id").autoIncrement()
    val firstName = varchar("firstName", 32)
    val lastName = varchar("lastName", 32)
    val email = varchar("email", 32)

    override val primaryKey = PrimaryKey(id)
}

val customers = mutableListOf(
    Customer.newEntry("Peter", "Brown", "peter@brown.com"),
    Customer.newEntry("Samantha", "Fox", "sam@fox.com")
)