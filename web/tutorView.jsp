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
        <link rel="stylesheet" href="tutorDelete.css">
    </head>
    <body>
         <!-- header and navigation bar starts -->
  <header>
    <h2>Welcome <%out.println(session.getAttribute("username"));%></h2>
    <nav class="topnav" id="myTopnav">
      <a href="tutorHome.jsp">Home</a>
      <a href="#" class="active">View Description</a>
      <a href="logout.jsp">Log out</a>
      <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
      </a>
    </nav>
  </header>
  <!-- header and navigation bar end -->

  <!-- tutor view form start -->
        
        <section class="formcontainer">
        <form action="TutorServlet" method="post">
            <h2>View Description</h2>
            <div class='inputs'>
               <input style="visibility:hidden;" type="text" name="username" placeholder="username" 
                      value="<%out.println(session.getAttribute("username"));%>">
            </div>
            <div class='inputs'>
                <input type="submit" value="View Description" name="action">
            </div>
        </form>
        </section>
        
   <!-- tutor view form end -->
   
   <!-- footer section start -->
  <footer>
    <p>copyright &#169; 2024 - <span>Max Home Tuition</span></p>
  </footer>
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
