package com.Web;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.time.*;
import java.util.Date;




@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet 
{
    @Override
    public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        
        PrintWriter out = res.getWriter();
        LocalTime currenttime = LocalTime.now();
        HttpSession session = req.getSession();
         
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        try
        {
            if(Service.adminloginCheck(username, password))
            {
                Admin admin = new Admin(username,password);
                
                session.setAttribute("username",admin.getUsername());
                session.setMaxInactiveInterval(15);
                RequestDispatcher rd = req.getRequestDispatcher("adminHome.jsp");
                rd.forward(req,res);
            }
            else if(Service.tutorloginCheck(username, password))
            {
                Tutor tutor = Service.selectTutor(username,password);
                LocalTime before = LocalTime.of(tutor.getAfterhour(),tutor.getAfterminute());
                LocalTime after = LocalTime.of(21,0);
                LocalDate todaydate = LocalDate.now();
                session.setAttribute("waittime",before);
                
                if(currenttime.isAfter(before) && currenttime.isBefore(after))
                {
                    session.setAttribute("todaydate", todaydate);
                    session.setAttribute("username",tutor.getUsername());
                    session.setAttribute("beforehour",tutor.getBeforehour());
                    session.setAttribute("beforeminute",tutor.getBeforeminute());
                    session.setAttribute("afterhour",tutor.getAfterhour());
                    session.setAttribute("username",tutor.getUsername());
                    
                    int diffhour = tutor.getAfterhour() - tutor.getBeforehour();
                    int diffminute = tutor.getAfterminute()- tutor.getBeforeminute();
                    session.setAttribute("diffhour",diffhour);
                    session.setAttribute("diffminute",diffminute);
                    session.setMaxInactiveInterval(15);
                    RequestDispatcher rd = req.getRequestDispatcher("tutorHome.jsp");
                    rd.forward(req,res);
                }
                else
                {
                    RequestDispatcher rd = req.getRequestDispatcher("tutorWait.jsp");
                    rd.forward(req,res);
                }
            }
            else
            {
                RequestDispatcher rd = req.getRequestDispatcher("wronguser.jsp");
                rd.forward(req,res);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
