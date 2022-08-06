<#-- @ftlvariable name="customers" type="kotlin.collections.List<com.vatrebukh.model.Customer>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <table border=1>
        <thead>
        <tr valign="top">
            <th colspan="1">Id</th>
            <th colspan="4">Name</th>
            <th align="left">Email</th>
        </tr>
        </thead>
        <tbody>
        <#list customers as customer>
        <tr><td colspan="1"><a href="/ui/customer/${customer.id}">${customer.id}</a><td colspan="4">${customer.firstName} ${customer.lastName}<td align="left">${customer.email}
        </#list>
        </tbody>
    </table>
    <p>
        <a href="/ui/customer/new">Register new customer</a>
    </p>
</@layout.header>