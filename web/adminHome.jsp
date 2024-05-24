<%-- 
    Document   : adminHome
    Created on : May 21, 2024, 9:27:24 AM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>&#128214; Admin Home - Max Home Tuition &#128214;</title>
<link rel="stylesheet" href="adminHome.css">
<!-- fontawesome link attached -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
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
        
        <!-- header section starts -->
        <header>
            <h2>Welcome Admin</h2>
            <nav class="topnav" id="myTopnav">
                <a href="#" class="active">Home</a>
                <a href="adminChangePassword.jsp">Change Password</a>
                <a href="addTutor.jsp">Add Tutor</a>
                <a href="tutorUpdate.jsp">Update Tutor</a>
                <a href="tutorDelete.jsp">Delete Tutor</a>
                <a href="logout.jsp">Log out</a>
                <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i></a>
            </nav>
        </header>
        <!-- header section end -->
        
        <form action="TutorServlet" method=""post>
            <input type="submit" value="SelectAll" name ="action">
        </form>
        
        <!-- footer section starts -->
        <footer><p>copyright &#169; 2024 - <span>Max Home Tuition</span></p></footer>
        <!-- footer section end -->
        
        <!-- internal js attached for navigation bar -->
        <script>
        function myFunction() {
            var x = document.getElementById("myTopnav");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }
        </script>

        </body>
    </html>
