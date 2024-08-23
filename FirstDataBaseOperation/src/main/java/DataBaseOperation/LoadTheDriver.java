package DataBaseOperation;

public class LoadTheDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DRIVER LOADED");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
