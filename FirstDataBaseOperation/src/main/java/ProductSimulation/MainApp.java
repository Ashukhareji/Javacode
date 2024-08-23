package ProductSimulation;

import java.util.Scanner;

public class MainApp {
    private static Scanner scanner=new Scanner(System.in);
    private static ProductOperation po=new ProductOperation();
    private static void operation(){
        boolean status=true;
        while (status) {
            System.out.println("1. ADD PRODUCT");
            System.out.println("2. UPDATE PRODUCT");
            System.out.println("3. DELETE PRODUCT");
            System.out.println("4. DISPLAY PRODUCT");
            System.out.println("5. EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    acceptData();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    break;
                case 4:
                    po.displayData();
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING");
                    status=false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }
    }
    private static void acceptData(){
        System.out.println("ENTER PRODUCT ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        scanner.nextLine();
        String name= scanner.nextLine().toUpperCase();
        System.out.println("ENTER PRODUCT PRICE");
        double price= scanner.nextDouble();
        System.out.println("ENTER PRODUCT QUANTITY");
        int qty= scanner.nextInt();
        System.out.println("ENTER PRODUCT CATEGORY");
        scanner.nextLine();
        String cat= scanner.nextLine().toUpperCase();
        po.insertData(id,name,price,qty,cat);
    }
    private static void update(){
        System.out.println("ENTER ID");
        int id= scanner.nextInt();
        System.out.println("ENTER PRICE");
        double price= scanner.nextDouble();
        po.updateData(id,price);
    }
    public static void main(String[] args) {
        operation();
    }
}
