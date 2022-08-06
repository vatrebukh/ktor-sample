<#import "_layout.ftl" as layout />
<@layout.header>
    <div style="text-align: left">
        <h3>Register customer</h3>
        <form action="/ui/customer" method="post">
            <p>
                First Name: <input type="text" name="firstName">
            </p>
            <p>
                Last Name: <input type="text" name="lastName">
            </p>
            <p>
                Email: <input type="text" name="email">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>