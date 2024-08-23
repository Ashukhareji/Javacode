package DataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate("insert into employee values(2,'AKSHAY',24999.99)");
            System.out.println(count+" RECORD INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
