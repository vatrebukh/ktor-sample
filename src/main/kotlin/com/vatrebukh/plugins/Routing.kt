package com.vatrebukh.plugins

import com.vatrebukh.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.webjars.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondRedirect("/ui/customer")
        }
    }

    routing {
        customerRouting()
    }

    routing {
        static("/static") {
            resources("files")
        }
    }

    install(Webjars) {
        path = "assets"
    }

}
