package DataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDataDemo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER EMPLOYEE ID");
        int id= scanner.nextInt();
        System.out.println("ENTER NAME");
        String name= scanner.next();
        System.out.println("ENTER SALARY");
        double sal= scanner.nextDouble();

        String query="insert into employee values("+id+",'"+name+"',"+sal+")";
        Connection con=null;
        Statement stmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            if(count>0){
                System.out.println("DATA INSERTED SUCCESSFULLY");
            }else {
                System.out.println("DATA IS NOT INSERTED");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
