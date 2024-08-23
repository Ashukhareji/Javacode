package SaveFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class DownloadImages {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","sql123");
            pstmt=con.prepareStatement("select * from temp where id=?");
            pstmt.setInt(1,1);

            ResultSet rs=pstmt.executeQuery();

            if(rs.next()){
                int id=rs.getInt(1);
                Blob blob=rs.getBlob(2);
                byte[] b;
                b=blob.getBytes(1,(int) blob.length());

                String name="temp";
                File file=new File("F:\\Workdata\\"+name+".png");
                FileOutputStream fout=new FileOutputStream(file);
                fout.write(b);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
