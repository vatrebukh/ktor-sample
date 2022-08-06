package com.vatrebukh.model

import kotlinx.serialization.Serializable
import java.util.concurrent.atomic.AtomicInteger

@Serializable
data class Customer(val id: Int, var firstName: String, var lastName: String, var email: String?) {
    companion object {
        private val idCounter = AtomicInteger()

        fun newEntry(firstName: String, lastName: String, email: String?) = Customer(idCounter.getAndIncrement(), firstName, lastName, email ?: "")
    }
}

val customers = mutableListOf(
    Customer.newEntry("Peter", "Brown", "peter@brown.com"),
    Customer.newEntry("Samantha", "Fox", "sam@fox.com")
)