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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;



@WebServlet(name = "TutorServlet", urlPatterns = {"/TutorServlet"})

public class TutorServlet extends HttpServlet
{
   
    @Override
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        
        String action = req.getParameter("action");
         
        if(action.equals("Insert"))
        {
            try 
            {
                insert(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
           
        }
        else if(action.equals("Delete"))
        {
            try 
            {
                delete(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
        }
        else if(action.equals("Update"))
        {
            try 
            {
                update(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
        }
        else if(action.equals("SelectAll"))
        {
            try 
            {
                selectAllTutor(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
        }
        else if(action.equals("Save Work"))
        {
            try 
            {
                saveWork(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
        }
        
        else if(action.equals("View Description"))
        {
            try 
            {
                viewDescription(req,res);
            }
            catch(Exception e)
            {
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                req.setAttribute("exception",e);
                rd.forward(req,res);
            }
        } 
    }
    
    
    // New Tutor Insert method
    public static void insert(HttpServletRequest req,HttpServletResponse res) throws IOException, SQLException, ClassNotFoundException
    {
        PrintWriter out = res.getWriter();
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String profilename = req.getParameter("profilename");
        int beforehour = Integer.parseInt(req.getParameter("beforehour"));
        int beforeminute = Integer.parseInt(req.getParameter("beforeminute"));
        int afterhour = Integer.parseInt(req.getParameter("afterhour"));
        int afterminute = Integer.parseInt(req.getParameter("afterminute"));
        
        Tutor tutor = new Tutor(username,password,profilename,beforehour,beforeminute,afterhour,afterminute);
        if(Service.insertTutor(tutor))
        {
            out.println("Inserted Successfully");
        }
        else
        {
            out.println("Insert Is Fail");
        }
    }
    
    
    // Existing Tutor Delete method
    public static void delete(HttpServletRequest req,HttpServletResponse res) throws IOException, SQLException, ClassNotFoundException
    {
        PrintWriter out = res.getWriter();
        
        String username = req.getParameter("username");
        Tutor tutor = new Tutor(username);

        if(Service.deleteTutor(tutor.getUsername()))
        {
            out.println("Successfully Deleted");
        }
        else
        {
            out.print("Deleted Failed");
        }
        
    }


    // Existing tutor Update method
    public static void update(HttpServletRequest req,HttpServletResponse res) throws IOException, SQLException, ClassNotFoundException
    {
        PrintWriter out = res.getWriter();
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String profilename = req.getParameter("profilename");
        int beforehour = Integer.parseInt(req.getParameter("beforehour"));
        int beforeminute = Integer.parseInt(req.getParameter("beforeminute"));
        int afterhour = Integer.parseInt(req.getParameter("afterhour"));
        int afterminute = Integer.parseInt(req.getParameter("afterminute"));

        
        Tutor tutor = new Tutor(username,password,profilename,beforehour,beforeminute,afterhour,afterminute);
        if(Service.updateTutor(tutor))
        {
            out.println("Updated Successfully");
        }
        else
        {
            out.println("Update Is Fail");
        }
    }
    
    
    //Select All the Existing Tutor
    public static void selectAllTutor(HttpServletRequest req,HttpServletResponse res) throws IOException, SQLException, ClassNotFoundException, ServletException
    {
       PrintWriter out = res.getWriter();
        
        ArrayList<Tutor> tutorArray = Service.selectAllTutor();
        Tutor tutor = new Tutor();
        out.println("<html><body>");
        out.println("<form action=\"TutorServlet\" method=\"post\">"+
"            <input type=\"text\" name=\"username\" placeholder=\"username\"><br><br>\n" +
"            <input type=\"submit\" value=\"View Description\" name=\"action\">\n" +
"        </form>");
        out.println("<br><hr><br>");
        out.println("<h1>Tutor List</h1>");
        out.println("<table border='1'><tr><th>Username</th>");
        out.println("<th>Password</th>");
        out.println("<th>Profile Name</th>");
        out.println("<th>Before Hour</th>");
        out.println("<th>Before Minute</th>");
        out.println("<th>After Hour</th>");
        out.println("<th>After Minute</th></tr>");
        for(Tutor t : tutorArray)
        {
            out.println("<tr>");
            out.println("<td>"+t.getUsername()+"</td>");
            out.println("<td>"+t.getPassword()+"</td>");
            out.println("<td>"+t.getProfilename()+"</td>");
            out.println("<td>"+t.getBeforehour()+"</td>");
            out.println("<td>"+t.getBeforeminute()+"</td>");
            out.println("<td>"+t.getAfterhour()+"</td>");
            out.println("<td>"+t.getAfterminute()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
    
    
    //Save Description with current date
    public static void saveWork(HttpServletRequest req,HttpServletResponse res)throws IOException, SQLException, ClassNotFoundException, ServletException
    {
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        LocalDate todaydate = LocalDate.now();
        String username = req.getParameter("username");
        String description = req.getParameter("description");
        int intimehour = Integer.parseInt(req.getParameter("intimehour"));
        int intimeminute = Integer.parseInt(req.getParameter("intimeminute"));
        int outtimehour = Integer.parseInt(req.getParameter("outtimehour"));
        int outtimeminute = Integer.parseInt(req.getParameter("outtimeminute"));
        
        StringBuilder s = new StringBuilder();
        int l = username.length();
        for(int i = 0;i < l;i++)
        {
            if(username.charAt(i) != ' ')
            {
                s.append(username.charAt(i));
            }
        }
        String user = s.toString();
        int dhour = outtimehour - intimehour;
        int dminute = outtimeminute - intimeminute;
        
        /* int originalhour = 0,originalminute = 0;
        
        int a = Integer.parseInt((String) session.getAttribute("diffhour"));
        int b = Integer.parseInt((String) session.getAttribute("diffminute"));
        if(a < dhour || b < dminute)
        {
            originalhour = a;
            originalminute = b;
        }
        else
        {
            originalhour = dhour;
            originalminute = dminute;
        }*/
        Description des = new Description(todaydate.toString(),description,intimehour,intimeminute,outtimehour,
               outtimeminute,dhour,dminute);
        Connection con = Connect.getCon();
        Statement sm = con.createStatement();
        String query = "insert into "+user.toLowerCase()+" values('"+des.getTodaydate()+"','"+des.getDescription()+"',"
                +des.getIntimehour()+","+des.getIntimeminute()+","+des.getOuttimehour()+","+des.getOuttimeminute()+","
                +des.getDurationhour()+","+des.getDurationminute()+");";
        int row = sm.executeUpdate(query);
        if(row > 0)
        {
            out.println("Description Added");
        }
        else
        {
            out.println("Description Added Failed");
        }
        
        
    }
    
    
    //View Description of tutor
    public static void viewDescription(HttpServletRequest req,HttpServletResponse res)throws IOException, SQLException, ClassNotFoundException, ServletException
    {
        PrintWriter out = res.getWriter();
        String username = req.getParameter("username");
        ArrayList<Description> arr = new ArrayList<>();
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select * from "+username+";");
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            arr.add(new Description(rs.getString("todaydate"),rs.getString("description"),rs.getInt("intimehour"),
            rs.getInt("intimeminute"),rs.getInt("outtimehour"),rs.getInt("outtimehour"),rs.getInt("durationhour"),
                    rs.getInt("durationminute")));
        }
        out.println("<html><body>");
        out.println("<br><hr><br>");
        out.println("<h1>Description</h1>");
        out.println("<table border='1'><tr><th>Date</th>");
        out.println("<th>Description</th>");
        out.println("<th>In Time Hour</th>");
        out.println("<th>In Time Minute</th>");
        out.println("<th>Out Time Hour</th>");
        out.println("<th>Out Time Minute</th>");
        out.println("<th>Duration Hour</th>");
        out.println("<t><th>Duration Minute</th></tr>");
        for(Description d : arr)
            {
            out.println("<tr>");
            out.println("<td>"+d.getTodaydate()+"</td>");
            out.println("<td>"+d.getDescription()+"</td>");
            out.println("<td>"+d.getIntimehour()+"</td>");
            out.println("<td>"+d.getIntimehour()+"</td>");
            out.println("<td>"+d.getOuttimehour()+"</td>");
            out.println("<td>"+d.getOuttimeminute()+"</td>");
            out.println("<td>"+d.getDurationhour()+"</td>");
            out.println("<td>"+d.getDurationminute()+"</td>");
            out.println("</tr>");
        }                                      
        out.println("</table>");
        out.println("</body></html>");
    }
}
