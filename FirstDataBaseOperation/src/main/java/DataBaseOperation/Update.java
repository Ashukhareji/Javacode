package DataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER EMPLOYEE ID");
        int id= scanner.nextInt();
        System.out.println("ENTER EMPLOYEE DESIGNATION");
        String desg= scanner.next();

        Connection con;
        Statement stmt;

        String query="update employee set emp_desg='"+desg+"' " +
                "where emp_id="+id;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);

            if(count>0){
                System.out.println(count+" RECORDS UPDATED");
            }else {
                System.out.println("RECORD NOT UPDATED");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
