package PointsTableOperations;

import java.sql.*;

public class Operations {
    static Connection con;
    static String url="jdbc:mysql://localhost:3306/1emj10";
    static String  username="root";
    static  String password="sql123";
    static {
        try {
            con= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void question1() {
        //DISPLAY THE POINTS TABLE
        String query1="SELECT * FROM pointstable ORDER BY points DESC,netrunrate DESC";
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement=con.prepareStatement(query1);
            resultSet=preparedStatement.executeQuery();
            int i=1;
            System.out.println("NO TEAM \tMATCHES WON LOST NETRUNRATE POINTS");
            while (resultSet.next()){
                System.out.print(i+" ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.print(resultSet.getInt(3)+"\t");
                System.out.print(resultSet.getInt(4)+"\t");
                System.out.print(resultSet.getInt(5)+"\t");
                System.out.print(resultSet.getDouble(6)+"\t");
                System.out.print(resultSet.getInt(7)+"\t");
                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void question2() {
        //DISPLAY THE TEAM WHICH HAS HIGHEST CHANCES FOR QUALIFYING.
        String query1="SELECT * FROM pointstable ORDER BY points DESC,netrunrate DESC LIMIT 4";
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement=con.prepareStatement(query1);
            resultSet=preparedStatement.executeQuery();
            int i=1;
            System.out.println("NO TEAM \tMATCHES WON LOST NETRUNRATE POINTS");
            while (resultSet.next()){
                System.out.print(i+" ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.print(resultSet.getInt(3)+"\t");
                System.out.print(resultSet.getInt(4)+"\t");
                System.out.print(resultSet.getInt(5)+"\t");
                System.out.print(resultSet.getDouble(6)+"\t");
                System.out.print(resultSet.getInt(7)+"\t");
                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void question6(){
        String s1="SELECT points,COUNT(points) AS temp FROM pointstable GROUP BY points ORDER BY temp DESC LIMIT 1";
        Statement statement;
        ResultSet rs1,rs2;
        try {
            statement=con.createStatement();
            rs1=statement.executeQuery(s1);
            int i=1;
            if(rs1.next()){
                int points= rs1.getInt(1);
                String s2="select * from pointstable where points="+points;
                rs2= statement.executeQuery(s2);
                while (rs2.next()){
                    System.out.print(i+" ");
                    System.out.println(rs2.getString(2));
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void question7(){
        char ch='a';
        String query="SELECT team FROM pointstable WHERE team LIKE '%"+ch+"%'";
    }
}
