package SaveFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFile {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1emj10","root","sql123");
            pstmt=con.prepareStatement("insert into temp values(?,?)");
            pstmt.setInt(1,1);

            File file=new File("D:\\javaf");
            FileInputStream fin=new FileInputStream(file);

            pstmt.setBlob(2,fin);

            int count=pstmt.executeUpdate();
            System.out.println(count+" DATA INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
