<%-- 
    Document   : tutorWait
    Created on : May 22, 2024, 1:46:46 PM
    Author     : Santhosh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>&#128214; Wrong User - Max Home Tuition &#128214;</title>
    <!-- internal css starts -->
    <style>
        * {
            margin: 0;
            box-sizing: border-box;
            font-family: sans-serif;
        }

        /* container styles */
        .container {
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
        }

        /* message box contains emoji and error message */
        .message-box {
            max-width: 380px;
            max-height: 120px;
            margin-top: 100px;
            padding: 20px;
            background-color: #f48982;
            border-radius: 9px;
            display: flex;
            box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2), 0 4px 25px 0 rgb(0, 0, 0);
        }

        /* Danger logo style */
        .message-box>p {
            font-size: 50px;
            margin: 0;
        }

        /* display error message  */
        .message-box>div {
            color: #f2efee;
            text-align: center;
            font-size: 20px;
            align-content: center;
        }

        /* try again link styles */
        .message-box>div a {
            text-decoration: none;
            color:rgb(13, 13, 118);
        }

        /* media queries for mobile responsive */
        @media screen and (max-width: 480px) {
            .message-box {
                padding: 10px;
            }

            .message-box>p {
                font-size: 40px;
                align-self: center;
            }

            .message-box>div{
                font-size: 16px;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="message-box">
            <p>⚠️</p>
            <div>
                <p><%out.println("After "+session.getAttribute("waittime")+" ,You will log in this website");%></p>
                <p>click to back then <b><a href="index.jsp">try again</a></b></p>
            </div>
        </div>
    </div>

</body>

</html>
