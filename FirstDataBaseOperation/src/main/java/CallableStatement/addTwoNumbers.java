package CallableStatement;

import java.sql.*;
import java.util.Scanner;

public class addTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NUMBER 1");
        int num1= scanner.nextInt();
        System.out.println("ENTER NUMBER 2");
        int num2= scanner.nextInt();

        Connection con;
        CallableStatement cstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            cstmt= con.prepareCall("{?=call addNumbers(?,?)}");
            cstmt.setInt(2,num1);
            cstmt.setInt(3,num2);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();

            System.out.println("ADDITION IS "+cstmt.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
