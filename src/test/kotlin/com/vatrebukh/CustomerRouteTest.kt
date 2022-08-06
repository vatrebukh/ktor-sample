package com.vatrebukh

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerRouteTest {

    @Test
    fun testPostCustomer() = testApplication {

        val response = client.post("/customer") {
            contentType(ContentType.Application.Json)
            setBody("""{"id":"1","firstName":"John","lastName":"Cheesecake","email":"test@test.com"}""")
        }

        assertEquals(HttpStatusCode.Created, response.status)
    }
}