<%-- 
    Document   : logout.jsp
    Created on : May 21, 2024, 10:30:54 AM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv=[COLOR=red]"cache-control"
              
        <title></title>
    </head>
    <body>

        <%
          
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            session.setAttribute("username",null);
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
