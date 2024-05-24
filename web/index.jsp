<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>&#128214; Login - Max Home Tuition &#128214;</title>
    <link rel="stylesheet" href="./style.css">
    <!-- fontawesome link attached -->
    <script src="https://kit.fontawesome.com/f1a33637bb.js" crossorigin="anonymous"></script>
</head>

<body>
       
    <div class="container">
        <form action="LoginServlet" method="post">
            <h3>Log in</h3>
            <div class="iconstyle">
                <i class="fa-solid fa-user fa-flip"></i>
                <input type="text" name="username" id="username" required placeholder="Username">
            </div>
            <div class="iconstyle">
                <i class="fa-solid fa-lock fa-flip"></i>
                <input type="password" name="password" id="password" required placeholder="Password">
            </div>
            <input type="submit" value="Log in">
        </form>
    </div>


</body>

</html>
