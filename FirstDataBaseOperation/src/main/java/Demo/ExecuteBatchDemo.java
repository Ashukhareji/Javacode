package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class ExecuteBatchDemo {
    public static void main(String[] args) {
        LinkedList<ProductDto> productData=new LinkedList<>();

        ProductDto p1=new ProductDto();
        p1.setProductId(6);
        p1.setProductName("X-BOX");
        p1.setProductPrice(49999.99);
        p1.setProductQty(28);
        p1.setProductCat("GAMING");

        ProductDto p2=new ProductDto();
        p2.setProductId(7);
        p2.setProductName("SHOES");
        p2.setProductPrice(9999.99);
        p2.setProductQty(30);
        p2.setProductCat("FASHION");

        ProductDto p3=new ProductDto();
        p3.setProductId(8);
        p3.setProductName("MARKER");
        p3.setProductPrice(99.99);
        p3.setProductQty(280);
        p3.setProductCat("STATIONARY");

        ProductDto p4=new ProductDto(9,"WHITE-BOARD",3499.99,15,"STATIONARY");

        productData.add(p1);
        productData.add(p2);
        productData.add(p3);
        productData.add(p4);

        productData.add(new ProductDto(10,"HEDPHONE",2499.99,39,"ELECTRONICS"));

        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
            PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");

            for(ProductDto temp:productData){
                pstmt.setInt(1,temp.getProductId());
                pstmt.setString(2,temp.getProductName());
                pstmt.setDouble(3,temp.getProductPrice());
                pstmt.setInt(4,temp.getProductQty());
                pstmt.setString(5,temp.getProductCat());
                pstmt.addBatch();
            }
            int[] arr=pstmt.executeBatch();
            for(int i=0;i< arr.length;i++){
                System.out.println(arr[i]);
            }
            System.out.println(arr.length+" DATA ADDED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
