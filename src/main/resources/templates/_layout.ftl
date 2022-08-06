<#ftl attributes={"content_type" : "text/html;charset=utf-8"}>
<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Kotlin Journal</title>

    </head>
    <body style="text-align: center; font-family: sans-serif">
    <h1>Kotlin Ktor Journal </h1>
    <hr>
    <#nested>
    <a href="/">Back to the main page</a>
    <hr>
    <p><i>Powered by Ktor & Freemarker!</i></p>
    </body>
    </html>
</#macro>