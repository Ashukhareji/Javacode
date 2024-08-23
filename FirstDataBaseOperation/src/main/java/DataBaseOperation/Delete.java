package DataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER EMPLOYEE ID ");
        int id= scanner.nextInt();

        Connection con;
        Statement stmt;

        String query="delete from employee where emp_id="+id;

        String url="jdbc:mysql://localhost:3306/1ejm10";
        String userName="root";
        String password="sql123";

        try {
            con= DriverManager.getConnection(url,userName,password);
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+" RECORD DELETED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
