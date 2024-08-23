package PreapredStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        String query="insert into product values(?,?,?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,2);
            pstmt.setString(2,"MOBILE");
            pstmt.setDouble(3,34999.99);
            pstmt.setInt(4,19);
            pstmt.setString(5,"ELECTRONICS");
            int count=pstmt.executeUpdate();
            System.out.println(count+" DATA INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
