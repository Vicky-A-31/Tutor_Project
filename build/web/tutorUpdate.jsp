<%-- 
    Document   : tutorUpdate
    Created on : May 21, 2024, 1:04:57 PM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutor Update</title>
    </head>
    <body>
        <%
           
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
        %>
        <form action="TutorServlet" method ="post">
            <input type="text" name="username" placeholder="username"><br><br>
            <input type="text" name="password" placeholder="password"><br><br> 
            <input type="text" name="profilename" placeholder="profilename"><br><br> 
            <input type="number" name="beforehour" min="1" max="24" placeholder="beforehour"> 
            <input type="number" name="beforeminute" min="0" max="59" placeholder="beforeminute"><br><br>
            <input type="number" name="afterhour" min="1" max="24" placeholder="afterthour"> 
            <input type="number" name="afterminute" min="0" max="59" placeholder="afterminute"><br><br>
            <input type="submit" value="Update" name="action">
        </form>
       
    </body>
</html>
