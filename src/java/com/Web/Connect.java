package com.Web;

import java.sql.*;

//This class is used to Connect the mysql with this project
public class Connect 
{
    //This method is used to get mysql database connection
    public static Connection getCon()throws SQLException, ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/learning";
        String user = "root";
        String pass = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,user,pass);
        return con;
    }
}
