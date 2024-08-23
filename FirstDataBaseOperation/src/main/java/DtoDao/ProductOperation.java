package DtoDao;

import java.sql.*;

public class ProductOperation {
    static Connection con;
    private  static   String insertData="insert into product values(?,?,?,?,?)";

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int insertData(Product p1){
        int count=0;
        try {
            PreparedStatement pstmt= con.prepareStatement(insertData);

            pstmt.setInt(1,p1.getProductId());
            pstmt.setString(2,p1.getProductName());
            pstmt.setDouble(3,p1.getProductPrice());
            pstmt.setInt(4,p1.getProductQty());
            pstmt.setString(5,p1.getProductCat());

            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void purchase(Product p) {
        String query="select * from product where product_id=? and product_qty>=?";
        try {
            PreparedStatement pstmt= con.prepareStatement(query);
            pstmt.setInt(1,p.getProductId());
            pstmt.setInt(2,p.getProductQty());
            ResultSet rs=pstmt.executeQuery();

            if(rs.next()){
                String updateQuery="update product set product_qty=product_qty-? where product_id=?";
                PreparedStatement pstmt1=con.prepareStatement(updateQuery);
                pstmt1.setInt(1,p.getProductQty());
                pstmt1.setInt(2,p.getProductId());
                int count=pstmt1.executeUpdate();

                if(count>0)
                    System.out.println("PURCHASED");
                else
                    System.out.println("WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
