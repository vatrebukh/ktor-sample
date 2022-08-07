<#-- @ftlvariable name="customers" type="kotlin.collections.List<com.vatrebukh.model.Customer>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
        </tr>
        </thead>
        <tbody>
        <#list customers as customer>
        <tr>
            <th scope="row"><a href="/ui/customer/${customer.id}">${customer.id}</a></th>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
        </tr>
        </#list>
        </tbody>
    </table>
    <p>
        <a href="/ui/customer/new">Register new customer</a>
    </p>
</@layout.header>