<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>&#128214; Add Tutors - Max Home Tuition &#128214;</title>
  <link rel="stylesheet" href="addTutor.css">
  <!-- fontawesome link attached -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
        
        <%
            

            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
           
        %>
        
        
        <!-- header and navigation bar starts -->
  <header>
    <h2>Welcome Admin</h2>
    <nav class="topnav" id="myTopnav">
      <a href="adminHome.jsp">Home</a>
      <a href="adminChangePassword.jsp">Change Password</a>
      <a href="#" class="active">Add Tutor</a>
      <a href="tutorUpdate.jsp">Update Tutor</a>
      <a href="tutorDelete.jsp">Delete Tutor</a>
      <a href="logout.jsp">Log out</a>
      <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
      </a>
    </nav>
  </header>
  <!-- header and navigation bar end -->

  <!-- insert form starts for tutor add -->
  <section class="formcontainer">
      <form action="TutorServlet" method="post">
      <h2>Add New Tutor</h2>
      
      <div class="inputs">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="username" required>
      </div>
      
      <div class="inputs">
        <label for="password">Password</label>
        <input type="text" name="password" id="password" placeholder="password" required>
      </div>
      
      <div class="inputs">
        <label for="fullname">Full Name</label>
        <input type="text" name="profilename" id="profilename" placeholder="profile name" required>
      </div>
      
      <div>
        <p><b>Note :</b>Enter tutor taken time duration in 24 Format <br>Eg. 8 PM is 20 and 30 minutes is 30</p>
      </div>
  
      <div class="inputs">
        <label for="fromhour">From (Hours)</label>
        <input type="number" name="beforehour" id="fromhour" min="1" max="24" placeholder="starting time" required>
      </div>
      
      <div class="inputs">
        <label for="fromminute">From (Minutes)</label>
        <input type="number" name="beforeminute" id="fromminute" min="0" max="59" placeholder="starting time" required>
      </div>
      
      <div class="inputs">
        <label for="tohour">To (Hours)</label>
        <input type="number" name="afterhour" id="tohour" min="1" max="24" placeholder="end time" required>
      </div>
      
      <div class="inputs">
        <label for="tominute">To (Minutes)</label>
        <input type="number" name="afterminute" id="tominute" min="0" max="59" placeholder="end time" required>
      </div>

      <div class="inputs">
        <input type="submit" value="Insert" name="action">
      </div>
  
    </form>
  </section>
  <!-- insert form end for tutors add -->

  <!-- footer section starts -->
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
