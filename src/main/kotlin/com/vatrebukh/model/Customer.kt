package com.vatrebukh.model

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, var email: String)

val customerStorage = mutableListOf<Customer>()