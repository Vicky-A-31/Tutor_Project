<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            max-width: 700px;
            height: 160px;
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
            font-size: 16px;
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
                padding: 7px;
            }

            .message-box>p {
                font-size: 40px;
                align-self: center;
            }

            .message-box>div{
                font-size: 14px;
            }
        }
    </style>
    </head>
    <body>
        <div class="container">
        <div class="message-box">
            <p>⚠️</p>
            <div>
                <p><%out.println(request.getAttribute("exception"));%></p>
                <p>click to back then <b><a href="index.jsp">try again</a></b></p>
            </div>
        </div>
        </div>
        
    </body>
</html>
