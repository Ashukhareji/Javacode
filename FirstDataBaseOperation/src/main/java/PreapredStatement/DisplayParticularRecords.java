package PreapredStatement;

import java.sql.*;

public class DisplayParticularRecords {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        String query="select * from product where product_price between ? and ?";
        try {
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
             pstmt=con.prepareStatement(query);
             pstmt.setDouble(1,29999.99);
             pstmt.setDouble(2,39999.99);
             ResultSet rs =pstmt.executeQuery();

            System.out.println("ID\tNAME");
             while (rs.next()){
                 System.out.println(rs.getInt(1)+"\t"+rs.getString("product_name"));
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
