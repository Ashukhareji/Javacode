package Temp;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    static Connection con;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    int test(ProductDto temp) throws SQLException {
        String str="insert into product values(?,?,?,?,?)";

        PreparedStatement pstmt=con.prepareStatement(str);
        pstmt.setInt(1,temp.getProductId());
        pstmt.setString(2,temp.getProductName());
        pstmt.setDouble(3,temp.getProductPrice());
        pstmt.setInt(4,temp.getProductQty());
        pstmt.setString(5,temp.getProductCat());
        int count=pstmt.executeUpdate();
        return count;
    }

    ArrayList<ProductDto> display() throws SQLException {
        String query="select * from product";
        PreparedStatement ps= con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        ArrayList<ProductDto> arrayList=new ArrayList<>();

        ProductDto dto=null;

        while (rs.next()){
            int id=rs.getInt(1);
            String name=rs.getString(2);
            double price=rs.getDouble(3);
            int qty=rs.getInt(4);
            String cat=rs.getString(5);

            dto=new ProductDto();
            dto.setProductId(id);
            dto.setProductName(name);
            dto.setProductPrice(price);
            dto.setProductCat(cat);
            dto.setProductQty(qty);

            arrayList.add(dto);

        }
        return arrayList;
    }
}
