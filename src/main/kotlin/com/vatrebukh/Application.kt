package com.vatrebukh

import com.vatrebukh.dao.DatabaseFactory
import com.vatrebukh.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()
    configureTemplating()
}
