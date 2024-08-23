package Demo;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    private static Connection con;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int insertData(ProductDto dto){
        String insertData="insert into product values(?,?,?,?,?)";
        int count=0;
        try {
            PreparedStatement pstmt=con.prepareStatement(insertData);
            pstmt.setInt(1,dto.getProductId());
            pstmt.setString(2, dto.getProductName());
            pstmt.setDouble(3,dto.getProductPrice());
            pstmt.setInt(4,dto.getProductQty());
            pstmt.setString(5,dto.getProductCat());

           count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;

    }

    public int update(ProductDto dto){
        String query="update product set product_price=? where product_id=?";

        try {
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(2, dto.getProductId());
            pstmt.setDouble(1,dto.getProductPrice());

            int count=pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<ProductDto> displayData(){
        String query="select * from product";
        ArrayList<ProductDto> productData=new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price= rs.getDouble(3);
                int qty=rs.getInt(4);
                String cat=rs.getString(5);

                ProductDto dto=new ProductDto();
                dto.setProductId(id);
                dto.setProductName(name);
                dto.setProductPrice(price);
                dto.setProductQty(qty);
                dto.setProductCat(cat);

                productData.add(dto);
            }

            return productData;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDto purchaseProduct(ProductDto dto) {
        String query="select * from product where product_id=? and product_qty>=?";
        int count=0;
        ProductDto temp=null;
        try {
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, dto.getProductId());
            pstmt.setInt(2,dto.getProductQty());
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                String updateQuery="update product set product_qty=product_qty-? where product_id=?";
                PreparedStatement pstmt1=con.prepareStatement(updateQuery);
                pstmt1.setInt(1,dto.getProductQty());
                pstmt1.setInt(2,dto.getProductId());
                 count=pstmt1.executeUpdate();
                 temp=new ProductDto();
                 temp.setProductPrice(rs.getDouble(3));
            }
             return temp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
