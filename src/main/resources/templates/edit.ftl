<#-- @ftlvariable name="customer" type="com.vatrebukh.model.Customer" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit customer</h3>
        <form action="/ui/customer/${customer.id}" method="post">
            <p>
                First Name: <input type="text" name="firstName" value="${customer.firstName}">
            </p>
            <p>
                Last Name: <input type="text" name="lastName" value="${customer.lastName}">
            </p>
            <p>
                Email: <input type="text" name="email" value="${customer.email}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/ui/customer/${customer.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>