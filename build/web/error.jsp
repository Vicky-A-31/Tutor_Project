<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception</title>
    </head>
    <body>
        <h1>Exception</h1>
        <%out.println(request.getAttribute("exception"));
        %>
    </body>
</html>
