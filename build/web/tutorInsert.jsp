<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutor Insert</title>
    </head>
    <body>
        
        <%
            

            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
           
        %>
        
        
        <h1>Insert Tutor</h1>
        <form action="TutorServlet" method ="post">
            Name<input type="text" name="username" ><br><br>
            Password<input type="text" name="password" ><br><br> 
            Profile Name<input type="text" name="profilename" <br><br> 
            Before Hour<input type="number" name="beforehour" min="1" max="24" >
            Before Minute<input type="number" name="beforeminute" min="0" max="59" >
            <br><br>
            After Hour<input type="number" name="afterhour" min="1" max="24" >
            After Minute<input type="number" name="afterminute" min="0" max="59" >
            <br><br>
            <input type="submit" value="Insert" name="action">
        </form>
        <a href="logout.jsp">Logout</a>
       
    </body>
</html>
