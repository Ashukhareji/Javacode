package StoredProcedure;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class insertData {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String name= scanner.next();
        System.out.println("ENTER PRODUCT PRICE");
        double price= scanner.nextDouble();
        System.out.println("ENTER QTY");
        int qty= scanner.nextInt();
        System.out.println("ENTER CATEGORY");
        String cat= scanner.next();

        CallableStatement cstmt;

        try {
           cstmt= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123")
                    .prepareCall("{ call insertdata(?,?,?,?,?)}");

           cstmt.setInt(1,id);
           cstmt.setString(2,name);
           cstmt.setDouble(3,price);
           cstmt.setInt(4,qty);
           cstmt.setString(5,cat);

           int count=cstmt.executeUpdate();
            System.out.println(count+" DATA INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
