package PreapredStatement;

import java.sql.*;
import java.util.Scanner;

public class Validation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER USER NAME");
        String userName= scanner.next();
        System.out.println("ENTER PASSWORD");
        String password= scanner.next();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        String query="select * from user where userName=? and userPass=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,userName);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();

            if(rs.next()){
                if(rs.getString(1).equals(userName) && rs.getString(2).equals(password)){
                    System.out.println("LOGIN SUCCESSFUL");
                }else {
                    System.out.println("INVALID LOGIN");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
