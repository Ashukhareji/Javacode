package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Connection conn=ConnectionHelper.createConnection();
        PreparedStatement pstmt1,pstmt2;

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME");
        String name= scanner.next();
        System.out.println("ENTER ADDRESS");
        String address= scanner.next();
        try {
            pstmt1= conn.prepareStatement("insert into customer values(?,?,?)");
            pstmt1.setInt(1,0);
            pstmt1.setString(2,name);
            pstmt1.setString(3,address);
            int count=pstmt1.executeUpdate();

            if(count>0){
                System.out.println("CUSTOMER ADDED");
            }
            System.out.println("ENTER NUMBER OF ACCOUNT TO ADD INTO YOUR DATABASE");
            int num= scanner.nextInt();
            pstmt2= conn.prepareStatement("insert into accountdata values(?,?,?,?)");
            for(int i=0;i<num;i++){
                System.out.println("ENTER ACCOUNT NUMBER");
                int acc= scanner.nextInt();
                System.out.println("ENTER ACCOUNT TYPE");
                String type= scanner.next();
                System.out.println("ENTER BALANCE");
                double balance= scanner.nextDouble();

                pstmt2.setInt(1,acc);
                pstmt2.setString(2,type);
                pstmt2.setDouble(3,balance);
                pstmt2.setInt(4,2);
                pstmt2.addBatch();
            }
            int[] arr=pstmt2.executeBatch();
            System.out.println(arr.length+" DATA ADDED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
