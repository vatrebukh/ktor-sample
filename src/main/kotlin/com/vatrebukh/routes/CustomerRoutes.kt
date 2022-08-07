package com.vatrebukh.routes

import com.vatrebukh.dao.dao
import com.vatrebukh.model.Customer
import com.vatrebukh.model.customers
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.customerRouting() {

    route("/api/customer") {
        get {
            if (customers.isNotEmpty()) {
                call.respond(customers)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.OK)
            }
        }
        get("/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val customer =
                customers.find { it.id.toString() == id } ?: return@get call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            customers.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customers.removeIf { it.id.toString() == id }) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }

    route("/ui/customer") {
        get {
            call.respond(FreeMarkerContent("index.ftl", mapOf("customers" to dao.allCustomers())))
        }
        get("/new") {
            call.respond(FreeMarkerContent("new.ftl", model = null))
        }
        post {
            val formParams = call.receiveParameters()
            val firstName = formParams.getOrFail("firstName")
            val lastName = formParams.getOrFail("lastName")
            val email = formParams.getOrFail("email")
            val customer = dao.addNewCustomer(firstName, lastName, email)
            call.respondRedirect("/ui/customer/${customer?.id}")
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("show.ftl", mapOf("customer" to dao.customer(id))))
        }
        get("{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("edit.ftl", mapOf("customer" to dao.customer(id))))
        }
        post("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParams = call.receiveParameters()
            when (formParams.getOrFail("_action")) {
                "update" -> {
                    val firstName = formParams.getOrFail("firstName")
                    val lastName = formParams.getOrFail("lastName")
                    val email = formParams.getOrFail("email")
                    dao.editCustomer(id, firstName, lastName, email)
                    call.respondRedirect("/ui/customer/$id")
                }
                "delete" -> {
                    dao.deleteCustomer(id)
                    call.respondRedirect("/ui/customer")
                }
            }
        }
    }

}