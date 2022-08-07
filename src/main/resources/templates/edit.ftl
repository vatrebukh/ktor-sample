<#-- @ftlvariable name="customer" type="com.vatrebukh.model.Customer" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div style="text-align: left">
        <div class="container">
            <h3>Edit customer</h3>
            <form action="/ui/customer/${customer.id}" method="post">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">First name</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="firstName" value="${customer.firstName}">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Last name</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="lastName" value="${customer.lastName}">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Email</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="email" value="${customer.email}">
                </div>
                <button type="submit" class="btn btn-primary" name="_action" value="update">Submit</button>
                <button type="submit" class="btn btn-danger" name="_action" value="delete">Delete</button>
            </form>
        </div>
    </div>
</@layout.header>