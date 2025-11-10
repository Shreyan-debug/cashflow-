import java.sql.Connection;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Connection conn = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> BankingOperations.createAccount(conn, sc);
                case 2 -> BankingOperations.deposit(conn, sc);
                case 3 -> BankingOperations.withdraw(conn, sc);
                case 4 -> BankingOperations.checkBalance(conn, sc);
                case 5 -> {
                    System.out.println("Bye!"); System.exit(0);
                }
            }
        }
    }
}
