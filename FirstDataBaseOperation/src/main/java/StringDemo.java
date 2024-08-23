import java.util.ArrayList;
import java.util.TreeSet;

public class StringDemo {
    public static void main(String[] args) {
        Company c1=new Company();
        Product p1=new Product();
        p1.sellProduct(c1);
    }
}
class Company{
    String companyName="SAMSUNG";

}

class Product{
    void sellProduct(Company c){
        if(c.companyName.equals("SAMSUNG")){
            System.out.println("VALID PRODUCT");
        }else {
            System.out.println("INVALID PRODUCT");
        }
    }
}