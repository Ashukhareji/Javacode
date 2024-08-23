package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME");
        String name= scanner.next();
        System.out.println("ENTER ADDRESS");
        String address= scanner.next();
        PreparedStatement pstmt1=null;

        Connection con =ConnectionHelper.createConnection();
        try {
            PreparedStatement pstmt= con.prepareStatement("insert into customer values(?,?,?)");
            pstmt1= con.prepareStatement("insert into accountdata values(?,?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            int count=pstmt.executeUpdate();
            if(count>0){
                System.out.println("CUSTOMER ADDED");
            }

            System.out.println("ENTER NUMBER OF ACCOUNTS TO ADD INTO YOUR DATABASE");
            int num= scanner.nextInt();
            for(int i=0;i<num;i++){
                System.out.println("ENTER ACCOUNT NUMBER ");
                int accNumber= scanner.nextInt();
                System.out.println("ENTER ACCOUNT TYPE");
                String accType= scanner.next();
                System.out.println("ENTER ACCOUNT BALANCE");
                double bal= scanner.nextDouble();


                pstmt1.setInt(1,accNumber);
                pstmt1.setString(2,accType);
                pstmt1.setDouble(3,bal);
                pstmt1.setInt(4,1);
                pstmt1.addBatch();
            }
            int[] temp=pstmt1.executeBatch();
            System.out.println(temp.length+" ACCOUNT ADDED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
