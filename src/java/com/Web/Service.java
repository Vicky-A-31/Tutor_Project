package com.Web;


import java.sql.*;
import java.util.ArrayList;

//This class is used to write function for the project
public class Service 
{
    // This method is verify the admin login
    public static boolean adminloginCheck(String username,String password)throws SQLException,ClassNotFoundException
    {
        boolean loginStatus = false;
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select username,password from adminlogin where username = ? and "
                + "password = ?");
        
        ps.setString(1,username);
        ps.setString(2,password);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
            {
                loginStatus = true;
            }
        }
        return loginStatus;   
    }
    
    
    // This method is verify the tutor login
    public static boolean tutorloginCheck(String username,String password)throws SQLException,ClassNotFoundException
    {
        boolean loginStatus = false;
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select username,password from tutorlogin where username = ? "
                + "and password = ?");
    
        
        ps.setString(1,username);
        ps.setString(2,password);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
            {
                loginStatus = true;
            }
        }
        
        return loginStatus;   
    }
    

// This method is used to insert the new tutor to database
    public static boolean insertTutor(Tutor tutor) throws SQLException, ClassNotFoundException
    {
        boolean insertStatus = false;
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("insert into tutorlogin values(?,?,?,?,?,?,?)");
        ps.setString(1,tutor.getUsername());
        ps.setString(2,tutor.getPassword());
        ps.setString(3,tutor.getProfilename());
        ps.setInt(4,tutor.getBeforehour());
        ps.setInt(5,tutor.getBeforeminute());
        ps.setInt(6,tutor.getAfterhour());
        ps.setInt(7,tutor.getAfterminute());
        
        Statement ps1 = con.createStatement();
        String query = "create table "+tutor.getUsername()+"(todaydate varchar(50) primary key,description varchar(500),intimehour int,"
                + "intimeminute int,outtimehour int,outtimeminute int,durationhour int,durationminute int);";
       
        ps1.executeUpdate(query);
        int row = ps.executeUpdate();
        if(row > 0)
        {
            insertStatus = true;
        }
        return insertStatus;
    }


// This method is get the all details of tutor

    public static Tutor selectTutor(String username,String password)throws SQLException,ClassNotFoundException
    {
        Tutor tutor = new Tutor();
       
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select * from tutorlogin where username = ? and password = ?");
        
        ps.setString(1,username);
        ps.setString(2,password);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next())
        {
            tutor.setUsername(rs.getString("username"));
            tutor.setPassword(rs.getString("password"));
            tutor.setProfilename(rs.getString("profilename"));
            tutor.setBeforehour(rs.getInt("beforehour"));
            tutor.setBeforeminute(rs.getInt("beforeminute"));
            tutor.setAfterhour(rs.getInt("afterhour"));
            tutor.setAfterminute(rs.getInt("afterminute"));
        }
        return tutor;  
    }
    
    
// This method is used to delete the existing tutor
    public static boolean deleteTutor(String username)throws SQLException,ClassNotFoundException
    {
        
        boolean deleteStatus = false;
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("delete from tutorlogin where username=?");
        String user = username.toLowerCase();
        String query = "drop table "+user;
        Statement ps1 = con.createStatement();
        ps1.executeUpdate(query);
        ps.setString(1,username);
        
        int row = ps.executeUpdate();
        if(row > 0)
        {
            deleteStatus = true;
        }
        return deleteStatus;
    }
    
    
// This method is used to update the existing tutor
    public static boolean updateTutor(Tutor tutor) throws SQLException,ClassNotFoundException
    {
        boolean updateStatus = false;
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("update tutorlogin set password=?,profilename=?,beforehour=?,"
                + "beforeminute=?,afterhour=?,afterminute=? where username=?");
        ps.setString(1,tutor.getPassword());
        ps.setString(2,tutor.getProfilename());
        ps.setInt(3,tutor.getBeforehour());
        ps.setInt(4,tutor.getBeforeminute());
        ps.setInt(5,tutor.getAfterhour());
        ps.setInt(6,tutor.getAfterminute());
        ps.setString(7,tutor.getUsername());
        
        int row = ps.executeUpdate();
        if(row > 0)
        {
            updateStatus = true;
        }
        return updateStatus;
    }
    
    
// This method is used to select the all existing tutors
    public static ArrayList<Tutor> selectAllTutor()throws SQLException,ClassNotFoundException
    {
        ArrayList<Tutor> tutorArray = new ArrayList<>();
        
        Connection con = Connect.getCon();
        PreparedStatement ps = con.prepareStatement("select * from tutorlogin");
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            tutorArray.add(new Tutor(rs.getString("username"),rs.getString("password"),rs.getString("profilename"),
            rs.getInt("beforehour"),rs.getInt("beforeminute"),rs.getInt("afterhour"),rs.getInt("afterminute")));
        }

        return tutorArray;
    }
}
