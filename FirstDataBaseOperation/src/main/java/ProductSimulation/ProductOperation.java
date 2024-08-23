package ProductSimulation;

import java.sql.*;

public class ProductOperation {
    static Connection con;
    static Statement statement;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            statement=con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertData(int id, String name, double price, int qty, String cat) {
     String query="insert into product values("+id+",'"+name+"'," +
             ""+price+","+qty+",'"+cat+"')";
        try {
           int count=statement.executeUpdate(query);
            System.out.println(count+" DATA INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(int id, double price) {
        String query="update product set product_price="+price+" where product_id="+id;
        try {
            int count=statement.executeUpdate(query);
            System.out.println(count+" DATA UPDATED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayData() {
        String query="select * from product";
        ResultSet rs;
        try {
            rs=statement.executeQuery(query);
            System.out.println("ID NAME PRICE QTY CATEGORY");
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
