package Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner=new Scanner(System.in);

    private static void operation(){
        boolean status=true;

        while (status) {
            System.out.println("1. ADD PRODUCT");
            System.out.println("2. UPDATE PRODUCT");
            System.out.println("3. DELETE PRODUCT");
            System.out.println("4. PURCHASE PRODUCT");
            System.out.println("5. DISPLAY PRODUCT");
            System.out.println("6. EXIT");
            System.out.println("ENTER CHOICE");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    acceptProductDetails();
                    break;
                case 2:
                    updateData();
                    break;
                case 4:
                    purchaseProduct();
                    break;
                case 5:
                    displayData();
                    break;
                case 6:
                    status=false;
                    break;
            }
        }
    }
    private static void purchaseProduct(){
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT QTY");
        int qty= scanner.nextInt();

        ProductDto dto=new ProductDto();
        dto.setProductId(id);
        dto.setProductQty(qty);

        ProductDao dao=new ProductDao();
        ProductDto res=dao.purchaseProduct(dto);
        if(res!=null){
            System.out.println("PRODUCT PURCHASE SUCCESSFULLY");
            System.out.println("PAYABLE AMOUNT IS "+(res.getProductPrice()*qty));
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    private static void acceptProductDetails(){
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String name= scanner.next();
        System.out.println("ENTER PRODUCT PRICE");
        double price= scanner.nextDouble();
        System.out.println("ENTER QTY");
        int qty= scanner.nextInt();
        System.out.println("ENTER CATEGORY");
        String cat= scanner.next();

        ProductDto dto=new ProductDto();
        dto.setProductId(id);
        dto.setProductName(name);
        dto.setProductPrice(price);
        dto.setProductQty(qty);
        dto.setProductCat(cat);

        ProductDao dao=new ProductDao();
        int res=dao.insertData(dto);

        if(res>0){
            System.out.println(res+" DATA INSERTED");
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    private  static  void updateData(){
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT PRICE");
        double price= scanner.nextDouble();

        ProductDto dto=new ProductDto();
        dto.setProductId(id);
        dto.setProductPrice(price);


        ProductDao dao=new ProductDao();
        int res=dao.update(dto);

        if(res>0){
            System.out.println("SUCCESS");
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    private static void displayData(){
        ProductDao dao=new ProductDao();

        ArrayList<ProductDto> res =dao.displayData();

        System.out.println("ID NAME PRICE QTY CATEGORY");
        for(ProductDto data:res){
            System.out.print(data.getProductId()+" ");
            System.out.print(data.getProductName()+" ");
            System.out.print(data.getProductPrice()+" ");
            System.out.print(data.getProductQty()+" ");
            System.out.print(data.getProductCat()+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        operation();
    }
}
