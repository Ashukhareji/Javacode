package PointsTableOperations;

import java.util.Scanner;

public class MainApp {
    private  static Scanner scanner=new Scanner(System.in);
    private static void operations(){
        boolean status=true;
        while (status) {
            System.out.println("1. QUESTION");
            System.out.println("2. QUESTION");
            System.out.println("3. QUESTION");
            System.out.println("4. QUESTION");
            System.out.println("5. QUESTION");
            System.out.println("6. QUESTION");
            System.out.println("7. QUESTION");
            System.out.println("8. QUESTION");
            System.out.println("9. QUESTION");
            System.out.println("10. QUESTION");
            System.out.println("11. EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Operations.question1();
                    break;
                case 2:
                    Operations.question2();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    status=false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        operations();
    }
}
