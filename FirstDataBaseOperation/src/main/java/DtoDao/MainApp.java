package DtoDao;

import java.util.Scanner;

public class MainApp {
    private static Scanner scanner=new Scanner(System.in);
    private static void operations(){
        System.out.println("1. INSERT DATA");
        System.out.println("2. UPDATE DATA");
        System.out.println("3. DELETE DATA");
        System.out.println("4. PURCHASE PRODUCT");
        System.out.println("5. DISPLAY PRODUCTS");
        System.out.println("6. EXIT");
        System.out.println("ENTER YOUR CHOICE");
        int choice= scanner.nextInt();

        switch (choice){
            case 1:
                acceptData();
                break;
            case 4:
                purchaseProduct();
                break;
        }

    }
    private  static  void purchaseProduct(){
        System.out.println("ENTER ID");
        int id= scanner.nextInt();
        System.out.println("ENTER QTY");
        int qty= scanner.nextInt();

        Product p=new Product();
        p.setProductId(id);
        p.setProductQty(qty);

        ProductOperation po=new ProductOperation();
        po.purchase(p);
    }
    private  static void acceptData(){
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

        Product product=new Product();

        product.setProductId(id);
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductQty(qty);
        product.setProductCat(cat);

        ProductOperation po=new ProductOperation();
        int count=po.insertData(product);

        if(count>0){
            System.out.println(count+" DATA INSERTED");
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    public static void main(String[] args) {
        operations();
    }
}
