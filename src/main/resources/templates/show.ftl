<#-- @ftlvariable name="customer" type="com.vatrebukh.model.Customer" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <p>
            First Name: ${customer.firstName}
        </p>
        <p>
            Last Name: ${customer.lastName}
        </p>
        <p>
            Email: ${customer.email}
        </p>
        <hr>
        <p>
            <a href="/ui/customer/${customer.id}/edit">Edit customer</a>
        </p>
    </div>
</@layout.header>