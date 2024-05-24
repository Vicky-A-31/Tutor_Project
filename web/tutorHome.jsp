<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>&#128214; Tutor Home - Max Home Tuition &#128214;</title>
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
     
        
       <h2><%out.println("Welcome "+session.getAttribute("username"));%></h2>
       
       <a href="logout.jsp">Log Out</a>
       <a href="tutorView.jsp">View Description</a>
           
            <section class="formcontainer">
    <form action="TutorServlet" method="post">
        <%out.println("Date : "+session.getAttribute("todaydate"));%><br><br>
      
      <div class="inputs">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="username" required>
      </div>
      
      <div class="inputs">
        <label for="description">Description</label>
        <input type="text" name="description" id="description" placeholder="description" required>
      </div>
  
      <div class="inputs">
        <label for="intimehour">From (Hours)</label>
        <input type="number" name="intimehour" id="intimehour" min="1" max="24" placeholder="starting time" required>
      </div>
      
      <div class="inputs">
        <label for="intimeminute">From (Minutes)</label>
        <input type="number" name="intimeminute" id="intimeminute" min="0" max="59" placeholder="starting time" required>
      </div>
      
      <div class="inputs">
        <label for="outtimehour">To (Hours)</label>
        <input type="number" name="outtimehour" id="outtimehour" min="1" max="24" placeholder="end time" required>
      </div>
      
      <div class="inputs">
        <label for="outtimeminute">To (Minutes)</label>
        <input type="number" name="outtimeminute" id="outtimeminute" min="0" max="59" placeholder="end time" required>
      </div>

      <div class="inputs">
        <input type="submit" value="Save Work" name="action">
      </div>
  
    </form>
  </section>
  <!-- insert form end for tutors add -->

  <!-- footer section starts -->
  <footer>
    <p>copyright &#169; 2024 - <span>Max Home Tuition</span></p>
  </footer>
  <!-- footer section end -->

</body>

</html>
