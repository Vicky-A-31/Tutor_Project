<%-- 
    Document   : tutorView
    Created on : May 22, 2024, 11:45:54 AM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutor View</title>
    </head>
    <body>
        <form action="TutorServlet" method="post"> 
            <input type="text" name="username" placeholder="username">
            <input type="submit" value="View Description" name="action">
        </form>
    </body>
</html>
