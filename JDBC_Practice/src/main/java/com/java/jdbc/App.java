package com.java.jdbc;

import com.java.jdbc.jdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App{
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //connection code
            con = jdbcUtil.getConnection();

            //Insert Query
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO studentinfo(ID,SNAME,SAGE,SCITY)VALUES(5,'DIYA',33,'banglore')");

            //Retrieve Query
            rs=stmt.executeQuery("select *from studentinfo");
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("SNAME"));
                System.out.println("Age: " + rs.getInt("SAGE"));
                System.out.println("City: " + rs.getString("SCITY"));
                System.out.println("----------------------");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                jdbcUtil.closeConnection(con,stmt);
            }catch(SQLException e){
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}