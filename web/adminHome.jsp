<%-- 
    Document   : adminHome
    Created on : May 21, 2024, 9:27:24 AM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
           
            if(!(session.getAttribute("username").equals("Admin")))
            {
                response.sendRedirect("index.jsp");             
            }
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp"); 
            }
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="addTutor.jsp">Insert Tutor</a><br><br>
        <a href="tutorDelete.jsp">Delete Tutor</a><br><br>
        <a href="tutorUpdate.jsp">Update Tutor</a><br><br>
        <form action="TutorServlet" method=""post>
            <input type="submit" value="SelectAll" name ="action">
        </form>
        <a href="logout.jsp">Logout</a>
        
    </body>
</html>
