/* Practical Question: Student Management System using Java JDBC (Statement)
Problem Statement:
Create a Java application using JDBC and the Statement interface
to perform basic database operations on a MySQL database.
-------------------
Database: CollegeDB
-------------------
Table: Student
-------------------
CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(30),
    marks INT
);
-------------------
Requirements
Write a menu-driven Java program that uses the Statement interface to perform the following operations:
Connect to the MySQL database.
Insert a new student record.
Display all student records.
Search for a student by ID.
Update a student's marks using the student ID.
Delete a student record using the student ID.
Count the total number of student records.
Exit the application.
*/
package com.java.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;
public class simpleStatement {
    static Connection con=null;
    static Statement stmt=null;
    static ResultSet rs= null;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
            //Connecting with database
                con = jdbcUtil.getConnection();
                //Creating Student table
                stmt = con.createStatement();
                String query="CREATE TABLE IF NOT EXISTS Student(" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(50)," +
                        "age INT," +
                        "course VARCHAR(30)," +
                        "marks INT)";
               stmt.executeUpdate(query);
               System.out.println("Table created");
               //Menu driven program

            while(true){
            System.out.println("Student Management System\n----------------\n" +
                    "1)Insert a new student record.\n" +
                    "2)Display all student records.\n" +
                    "3)Search for a student by ID.\n" +
                    "4)Update a student's marks using the student ID.\n" +
                    "5)Delete a student record using the student ID.\n" +
                    "6)Count the total number of student records.\n" +
                    "7)Exit the application.");
            System.out.print("Enter your option : ");
            int option = input.nextInt();
            //Insertion operation
            if(option == 1){
                System.out.print("Enter the id : ");
                int id = input.nextInt();

                System.out.print("Enter the name : ");
                String name = input.next();

                System.out.print("Enter the age : ");
                int age = input.nextInt();

                System.out.print("Enter the coure : ");
                String course = input.next();

                System.out.print("Enter the CGPA : ");
                int marks = input.nextInt();

                query=("INSERT INTO Student(id,name,age,course,marks) VALUES("+id+",'"+name+"',"+age+",'"+course+"',"+marks+")");
                stmt.executeUpdate(query);

                System.out.print("Record inserted successfully");
            }
            else if(option ==2){
                rs=stmt.executeQuery("SELECT *FROM Student");
                while(rs.next()){
                    System.out.println("----------------------------");
                    System.out.println("ID : "+rs.getInt("id"));
                    System.out.println("Name : "+rs.getString("name"));
                    System.out.println("Age : "+rs.getInt("age"));
                    System.out.println("Course : "+rs.getString("course"));
                    System.out.println("Marks : "+rs.getInt("marks"));
                    System.out.println("----------------------------");
                }
            }
            else if(option ==7 ){
                System.out.println("Thank you ");
                break;
            }
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                jdbcUtil.closeConnection(con,stmt);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
