package Temp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static public void main(String[] args) throws SQLException {
        Map<String,Integer> map=new HashMap<>();
        map.put("ABC",10);
        map.put("XYZ",20);
        System.out.println(map.getOrDefault("PQR",50));
    }
    void demo2() throws SQLException {
        DAO dao=new DAO();
        ArrayList<ProductDto> res=dao.display();
        for(ProductDto data:res){
            System.out.print(data.getProductId());
            System.out.print(data.getProductName());
            System.out.println(data.getProductPrice());
        }
    }
    void demo() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER ID");
        int id= scanner.nextInt();
        System.out.println("ENTER NAME");
        String name= scanner.next();
        System.out.println("ENTER PRICE");
        double price= scanner.nextDouble();
        System.out.println("ENTER QTY");
        int qty= scanner.nextInt();
        System.out.println("ENTER CAT");
        String cat= scanner.next();

        ProductDto dto=new ProductDto();
        dto.setProductId(id);
        dto.setProductName(name);
        dto.setProductPrice(price);
        dto.setProductQty(qty);
        dto.setProductCat(cat);

        DAO dao=new DAO();
        int res=dao.test(dto);

        if(res>0){
            System.out.println(res+" DATA INSERTED");
        }else {
            System.out.println("ERROR");
        }
    }
}
