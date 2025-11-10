import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankingOperations {

    // Create account
    public static void createAccount(Connection conn, Scanner sc) throws Exception {
        System.out.print("Enter name: ");
        String name = sc.next();

        String sql = "INSERT INTO users(name, balance) VALUES(?, 0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.executeUpdate();

        System.out.println("Account created for " + name);
    }

    // Deposit money
    public static void deposit(Connection conn, Scanner sc) throws Exception {
        System.out.print("Enter user id: ");
        int id = sc.nextInt();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        String sql = "UPDATE users SET balance = balance + ? WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, id);
        ps.executeUpdate();

        System.out.println("Deposited " + amount);
    }

    // Withdraw money
    public static void withdraw(Connection conn, Scanner sc) throws Exception {
        System.out.print("Enter user id: ");
        int id = sc.nextInt();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        String sql = "UPDATE users SET balance = balance - ? WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, id);
        ps.executeUpdate();

        System.out.println("Withdrawn " + amount);
    }

    // Check balance
    public static void checkBalance(Connection conn, Scanner sc) throws Exception {
        System.out.print("Enter user id: ");
        int id = sc.nextInt();

        String sql = "SELECT balance FROM users WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Balance: " + rs.getDouble("balance"));
        }
    }
}
