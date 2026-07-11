import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/jdbclearning";
        String username = "root";
        String password = ".....";

        try {
            //Loading and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection code
            Connection con = DriverManager.getConnection(url, username, password);

            //Statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO studentinfo(ID,SNAME,SAGE,SCITY)VALUES(4,'SIYA',23,'banglore')");

            //Retrieve
            ResultSet rs=stmt.executeQuery("select *from studentinfo");
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
    }
}