<%-- 
    Document   : tutorView
    Created on : 24-May-2024, 10:42:50 pm
    Author     : vvbos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&#128214; View Description - Max Home Tuition &#128214;</title>
        <link rel="stylesheet" href="addTutor.css">
    </head>
    <body>
        <h2><%out.println("Welcome "+session.getAttribute("username"));%></h2>
        <a href="logout.jsp">Log Out</a>
        
        <section class="formcontainer">
        <form action="TutorServlet" method="post">
            <div class='inputs'>
               <input type="text" name="username" placeholder="username">
            </div>
            <div class='inputs'>
                <input type="submit" value="View Description" name="action">
            </div>
        </form>
        </section>
    </body>
</html>
