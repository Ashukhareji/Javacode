package DataBaseOperation;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayDemo1 {
    public static void main(String[] args) {
        try {
            Statement statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123").createStatement();
            ResultSet rs=statement.executeQuery("select emp_name,emp_desg from employee");
            System.out.println("EMPNAME\tEMPDESG");
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
