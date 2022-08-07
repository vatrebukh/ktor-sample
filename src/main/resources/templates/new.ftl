<#import "_layout.ftl" as layout />
<@layout.header>
    <div style="text-align: left">
        <div class="container">
            <h3>Register customer</h3>
            <form action="/ui/customer" method="post">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">First name</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="John" name="firstName">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Last name</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Silver" name="lastName">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Email</label>
                    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" name="email">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</@layout.header>