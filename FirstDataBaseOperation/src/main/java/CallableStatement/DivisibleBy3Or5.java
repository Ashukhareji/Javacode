package CallableStatement;

import java.sql.*;
import java.util.Scanner;

public class DivisibleBy3Or5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NUMBER ");
        int num= scanner.nextInt();

        Connection con;
        CallableStatement cstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            cstmt=con.prepareCall("{?=call divisible(?)}");
            cstmt.setInt(2,num);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            System.out.println(" MESSAGE "+cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
