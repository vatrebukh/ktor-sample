package com.vatrebukh.dao

import com.vatrebukh.dao.DatabaseFactory.dbQuery
import com.vatrebukh.model.Customer
import com.vatrebukh.model.Customers
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    override suspend fun allCustomers(): List<Customer> = dbQuery {
        Customers.selectAll().map(::resultRowToCustomer)
    }

    override suspend fun customer(id: Int): Customer? = dbQuery {
        Customers
            .select{Customers.id eq id}
            .map(this::resultRowToCustomer)
            .singleOrNull()
    }

    override suspend fun addNewCustomer(firstName: String, lastName: String, email: String?): Customer? = dbQuery {
        val insertStatement = Customers.insert {
            it[Customers.firstName] = firstName
            it[Customers.lastName] = lastName
            it[Customers.email] = email ?: ""
        }
        insertStatement.resultedValues?.singleOrNull()?.let(this::resultRowToCustomer)
    }

    override suspend fun editCustomer(id: Int, firstName: String, lastName: String, email: String?): Boolean = dbQuery {
        Customers.update({Customers.id eq id}) {
            it[Customers.firstName] = firstName
            it[Customers.lastName] = lastName
            it[Customers.email] = email ?: ""
        } > 0
    }

    override suspend fun deleteCustomer(id: Int): Boolean = dbQuery {
        Customers.deleteWhere { Customers.id eq id } > 0
    }

    private fun resultRowToCustomer(row: ResultRow) = Customer(
        id = row[Customers.id],
        firstName = row[Customers.firstName],
        lastName = row[Customers.lastName],
        email = row[Customers.email],
    )

}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        if(allCustomers().isEmpty()) {
            addNewCustomer("Peter", "Brown", "peter@brown.com")
        }
    }
}