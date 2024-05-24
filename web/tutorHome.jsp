<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%
           
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutor Home</title>
    </head>
    <body>
       <h1><%out.println(session.getAttribute("username"));%></h1>
       <form action="TutorServlet" method="post">
           <%out.println(session.getAttribute("todaydate"));%><br><br>
            Username<input type="text" name="username"><br><br>
            Description<input type ="text" name="description"><br><br> 
            In Time<input type="number" name="intimehour" min="1" max="24">
            <input typr="number" name="intimeminute" min="0" max="59"><br><br> 
            Out Time<input type="number" name="outtimehour" min="1" max="24">
            <input typr="number" name="outtimeminute" min="0" max="59"><br><br>
            <input type="submit" value="Save Work" name="action">
       </form>
        <a href="logout.jsp">Logout</a>
        
    </body>
</html>
