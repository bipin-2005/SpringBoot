/*
Practical 1: Employee Management System
Database: CompanyDB
CREATE TABLE Employee(
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    department VARCHAR(30),
    salary DOUBLE,
    city VARCHAR(30)
);
Requirements
Create a menu-driven Java program using PreparedStatement to:
-------------------------------------------------------------
Add a new employee.
Display all employees.
Search an employee by ID.
Update employee salary.
Display employees of a particular department.
Delete an employee.
Display employees with salary greater than a given amount.
Exit.
*/
package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class EmployeeManagementSystem {
    static Connection conn=null;
    static PreparedStatement pstmt= null;
    static ResultSet rs = null;

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        try{
            conn = jdbcUtil.getConnection();

            pstmt = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Employee (" +
                    "emp_id INT PRIMARY KEY,"+
                    "emp_name VARCHAR(50) NOT NULL,"+
                    "department VARCHAR(50),"+
                    "salary DOUBLE,"+
                    "city VARCHAR(60)"+")"
            );
            pstmt.executeUpdate();
            while(true){
                //Menu
                System.out.println("-------------------------------------------------------------\nEnter your option : \n" +
                        "1)Add a new employee.\n" +
                        "2)Display all employees.\n" +
                        "3)Search an employee by ID.\n" +
                        "4)Update employee salary.\n" +
                        "5)Display employees of a particular department.\n" +
                        "6)Delete an employee.\n" +
                        "7)Display employees with salary greater than a given amount.\n" +
                        "8)Exit.\n-------------------------------------------------------------");
                System.out.print("Enter your option : ");
                int option = input.nextInt();
                switch(option){
                    case 1:
                        try {
                            //Adding new employee
                            System.out.print("Enter the employee id: ");
                            int id = input.nextInt();

                            input.nextLine();
                            System.out.print("Enter the name of the employee : ");
                            String name = input.nextLine();

                            System.out.print("Enter the department name of the employee : ");
                            String dep = input.nextLine();

                            System.out.print("Enter the Salary of the employee : ");
                            double salary = input.nextDouble();
                            input.nextLine();
                            System.out.print("Enter the  city  name of the employee : ");
                            String city = input.nextLine();

                            String query = "INSERT INTO Employee(emp_id,emp_name,department,salary,city) VALUES(?,?,?,?,?)";
                            pstmt = conn.prepareStatement(query);
                            pstmt.setInt(1, id);
                            pstmt.setString(2, name);
                            pstmt.setString(3, dep);
                            pstmt.setDouble(4, salary);
                            pstmt.setString(5, city);

                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0)
                                System.out.println("Insertion sucessfull");
                            else
                                System.out.println("Failed to insert");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter the correct data type.");
                            input.nextLine(); // Clear the invalid input
                        }catch(SQLException e){
                            System.out.println("Employee ID already exists or database error.");
                        }
                        break;

                    case 2:
                        //Display all records
                        String query = "SELECT *FROM Employee";
                        pstmt = conn.prepareStatement(query);
                        rs = pstmt.executeQuery();
                        while(rs.next()){
                            System.out.println("ID : "+rs.getInt("emp_id"));
                            System.out.println("Name  : "+rs.getString("emp_name"));
                            System.out.println("Salary : "+rs.getDouble("salary"));
                            System.out.println("Department : "+rs.getString("department"));
                            System.out.println("City : "+rs.getString("city"));
                            System.out.println("-------------------------------------------------------------");
                        }
                        break;
                    case 3:
                        //Search an employee by ID
                        System.out.println("Enter employee ID: ");
                        int emp_id = input.nextInt();
                        query = "SELECT *FROM Employee WHERE emp_id=?";
                        pstmt= conn.prepareStatement(query);
                        pstmt.setInt(1,emp_id);
                        rs  = pstmt.executeQuery();
                        while(rs.next()){
                            System.out.println("ID : "+rs.getInt("emp_id"));
                            System.out.println("Name  : "+rs.getString("emp_name"));
                            System.out.println("Salary : "+rs.getDouble("salary"));
                            System.out.println("Department : "+rs.getString("department"));
                            System.out.println("City : "+rs.getString("city"));
                            System.out.println("-------------------------------------------------------------");
                    }
                        break;
                    case 4:
                        //update employee by salary
                        System.out.print("Enter the id of the employee : ");
                        int id = input.nextInt();
                        System.out.print("Enter the updated salary : ");
                        double sal=input.nextDouble();
                        String findQuery = "SELECT *FROM Employee WHERE emp_id = ?";
                        pstmt = conn.prepareStatement(findQuery);
                        pstmt.setInt(1,id);

                        rs=pstmt.executeQuery();

                        if(rs.next()){
                             String updateQuery = "UPDATE Employee SET salary = ? WHERE emp_id =?";
                             pstmt=conn.prepareStatement(updateQuery);
                             pstmt.setDouble(1,sal);
                             pstmt.setInt(2,id);

                             int rowsAffected = pstmt.executeUpdate();
                             if(rowsAffected>0){
                                 System.out.println("Updated successfully");
                             }
                             else{
                                 System.out.println("Failed to update");
                             }
                        }else{
                            System.out.println("ID does not exists");
                        }
                        break;
                    case 5:
                        //Display employees of a particular department
                        System.out.print("Enter the department : ");
                        input.nextLine();
                        String dep = input.nextLine();

                        String findDep = "SELECT  *FROM Employee WHERE department = ?";
                        pstmt = conn.prepareStatement(findDep);
                        pstmt.setString(1,dep);

                        rs=pstmt.executeQuery();
                        if (rs.next()) {
                            do {
                                System.out.println("ID : " + rs.getInt("emp_id"));
                                System.out.println("Name : " + rs.getString("emp_name"));
                                System.out.println("Department : " + rs.getString("department"));
                                System.out.println("Salary : " + rs.getDouble("salary"));
                                System.out.println("City : " + rs.getString("city"));
                                System.out.println("---------------------------");
                            } while (rs.next());
                        } else {
                            System.out.println("No employees found in the " + dep + " department.");
                        }
                        break;

                    case 6:
                        //Delete an employee
                        System.out.print("Enter the Employee id to be deleted :");
                         emp_id = input.nextInt();
                         String deleteQuery = "DELETE FROM Employee WHERE emp_id =?";
                         pstmt = conn.prepareStatement(deleteQuery);
                         pstmt.setInt(1,emp_id);
                         int rowsAffected=pstmt.executeUpdate();

                         if(rowsAffected>0){
                             System.out.println("Employee deleted");
                         }
                         else{
                             System.out.println("Faield to delete employee");
                         }
                         break;
                    case 7:
                        //Display employees with salary greater than a given amount

                        System.out.println("Enter the salary range :");
                        double salary = input.nextDouble();

                        query = "SELECT *FROM Employee WHERE salary >= ?";
                        pstmt=conn.prepareStatement(query);
                        pstmt.setDouble(1,salary);
                        rs = pstmt.executeQuery();
                        while(rs.next()){
                            System.out.println("ID : "+rs.getInt("emp_id"));
                            System.out.println("Name  : "+rs.getString("emp_name"));
                            System.out.println("Salary : "+rs.getDouble("salary"));
                            System.out.println("Department : "+rs.getString("department"));
                            System.out.println("City : "+rs.getString("city"));
                            System.out.println("-------------------------------------------------------------");
                        }
                        break;
                    case 8:
                            //exit
                            System.out.println("Thank you");
                            System.exit(0);
                            break;

                    default:
                        System.out.println("Something went wrong");
                }
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }


}
