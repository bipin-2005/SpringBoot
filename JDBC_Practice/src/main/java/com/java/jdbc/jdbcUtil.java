package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
    static{
        try{
            //Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //Connection with database
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/jdbclearning";
        String username = "root";
        String password = "coolrajak";
        return DriverManager.getConnection(url,username,password);
    }
    //Closing the connection
    public static void closeConnection(Connection connect, Statement statement)throws Exception{
            connect.close();
            statement.close();
    }
}
