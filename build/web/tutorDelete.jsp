<%-- 
    Document   : tutorDelete
    Created on : May 21, 2024, 10:08:56 AM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutor</title>
    </head>
    <body>
        <%
          
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }

        %>
        <h1>Delete Tutor</h1>
        <form action="TutorServlet" method ="post">
            <input type="text" name="username" placeholder="username"><br><br> 
            <input type="submit" value="Delete" name ="action">
        </form>
        <a href="logout.jsp">Logout</a>
       
    </body>
</html>
