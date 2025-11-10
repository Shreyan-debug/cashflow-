import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    @SuppressWarnings("UseSpecificCatch")
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/banking_db"; // your DB
            String user = "root";  // your MySQL username
            String pass = "root123"; // your MySQL password
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to Database!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
        }
        return conn;
    }
}
