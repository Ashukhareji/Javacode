import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {

    public static void main(String[] args) throws Exception
    {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
        PreparedStatement ps= con.prepareStatement("Update Employee set ename ='Ganesh' where eid=2");
        int i= ps.executeUpdate();

        if(i > 0) {
            System.out.println("Success");
        } else
            {
                System.out.println("Fail");
            }
        }
    }
