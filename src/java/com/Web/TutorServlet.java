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
        else if(action.equals("Change"))
        {
            try 
            {
                change(req,res);
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
            out.println("<html><body>"
                    + "<script>alert('Tutor Insertion Successfully');"
                    + "window.location = '/WebApplication/addTutor.jsp';</script>"
                    + "</body></html>");
        }
        else
        {
            out.println("<html><body>"
                    + "<script>alert('Tutor Insertion Failed');</script>"
                    + "</body></html>");
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
            out.println("<html><body>"
                    + "<script>alert('Tutor Deleted Successfully');</script>"
                    + "</body></html>");
        }
        else
        {
           out.println("<html><body>"
                    + "<script>alert('Tutor Deletion Fail');</script>"
                    + "</body></html>");
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
            out.println("<html><body>"
                    + "<script>alert('Tutor Information Updated Successfully');</script>"
                    + "</body></html>");
        }
        else
        {
            out.println("<html><body>"
                    + "<script>alert('Updation Fail');</script>"
                    + "</body></html>");
        }
    }
    
    
    //Select All the Existing Tutor
    public static void selectAllTutor(HttpServletRequest req,HttpServletResponse res) throws IOException, SQLException, ClassNotFoundException, ServletException
    {
       PrintWriter out = res.getWriter();
        
        ArrayList<Tutor> tutorArray = Service.selectAllTutor();
        Tutor tutor = new Tutor();
        out.println("<!DOCTYPE html>");
        out.println("<html><head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>&#128214; Tutor List - Max Home Tuition &#128214;</title><link rel=\"stylesheet\" href=\"showTable.css\"><body>");
        out.println("<form action=\"TutorServlet\" method=\"post\">"
                + "<div class='inputs'>"+
"            <input type=\"text\" name=\"username\" placeholder=\"username\"></div><br><br>\n" +
"            <div class='inputs'><input type=\"submit\" value=\"View Description\" name=\"action\"></div>\n" +
"        </form>");
        out.println("<br><hr>");
        out.println("<h2>Tutor List</h2>");
        out.println("<button type=\"button\" onclick=\"window.print()\">Print</button>\n" +
"    <div class=\"table-responsive\">");
        out.println("<table><tr><th>Username</th>");
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
        out.println("</table></div>");
        out.println("<br><br><p>Signature : </p>");
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
        int dhour,dminute;
        if((outtimeminute+60) - intimeminute >= 60)
        {
             dhour = outtimehour - intimehour;
             dminute = outtimeminute - intimeminute;
        }
        else
        {
            dhour = outtimehour-intimehour-1;
            dminute = (outtimeminute+60) - intimeminute; 
        }
       
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
            out.println("<html><body>"
                    + "<script>alert('Description Added Successfully');</script>"
                    + "</body></html>");
        }
        else
        {
            out.println("<html><body>"
                    + "<script>alert('Description Add Fail');</script>"
                    + "</body></html>");
        }
        
        
    }
    
    
    //View Description of tutor
    public static void viewDescription(HttpServletRequest req,HttpServletResponse res)throws IOException, SQLException, ClassNotFoundException, ServletException
    {
        PrintWriter out = res.getWriter();
        String username = req.getParameter("username");
        ArrayList<Description> arr = new ArrayList<Description>();
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select * from "+username+";");
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            arr.add(new Description(rs.getString("todaydate"),rs.getString("description"),rs.getInt("intimehour"),
            rs.getInt("intimeminute"),rs.getInt("outtimehour"),rs.getInt("outtimehour"),rs.getInt("durationhour"),
                    rs.getInt("durationminute")));
        }
        out.println("<!DOCTYPE html>");
        out.println("<html><head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>&#128214; Description List - Max Home Tuition &#128214;</title><link rel=\"stylesheet\" href=\"showTable.css\"><body>");
        out.println("<br><hr>");
        out.println("<h2>Description</h2>");
        out.println("<button type=\"button\" onclick=\"window.print()\">Print</button>\n" +
"    <div class=\"table-responsive\">");
        out.println("<table><tr><th>Date</th>");
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
        out.println("</table></div>");
        out.println("<br><br><p>Signature : </p>");
        out.println("</body></html>");
    }
    
    
    // Change password for admin
    public static void change(HttpServletRequest req,HttpServletResponse res)throws IOException, SQLException, ClassNotFoundException, ServletException
    {
        PrintWriter out = res.getWriter();
        String username = req.getParameter("username");
        String newpassword = req.getParameter("newpassword");
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("update adminlogin set password = ? where username=?");
        ps.setString(1,newpassword);
        ps.setString(2,username);
        int row= ps.executeUpdate();
        if(row > 0)
        {
            out.println("<html><body>"
                    + "<script>alert('Password Change Successfully');</script>"
                    + "</body></html>");
        }
        else
        {
            out.println("<html><body>"
                    + "<script>alert('Password Change Failed');</script>"
                    + "</body></html>");
        }
    }
}
