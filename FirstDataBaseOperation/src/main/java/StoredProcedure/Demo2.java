package StoredProcedure;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT PRICE");
        double price= scanner.nextDouble();
        System.out.println("ENTER ID TO DELETE PRODUCT ");
        int deleteId= scanner.nextInt();
        CallableStatement cstmt;

        cstmt= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123")
                .prepareCall("{ call demo(?,?,?)}");
        cstmt.setDouble(1,price);
        cstmt.setInt(2,id);
        cstmt.setInt(3,deleteId);

        int count=cstmt.executeUpdate();

        if(count>0){
            System.out.println("TASK COMPLETED");
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
}
