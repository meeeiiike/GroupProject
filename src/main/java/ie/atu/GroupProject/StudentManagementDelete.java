package ie.atu.GroupProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        //Database connection
        String url = "jdbc:mysql://localhost/sms";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            while (continueRunning) {
                System.out.println("Select table to delete data:");
                System.out.println("1. Department");
                System.out.println("2. Student");
                System.out.println("3. Staff");
                System.out.println("4. Course");
                System.out.println("5. Grades");
                System.out.println("6. Payment");
                System.out.println("7. College");
                System.out.println("8. Address");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 9) {
                    System.out.println("Exiting...");
                    continueRunning = false;
                } else {
                    System.out.println("Feature not yet implemented.");
                }
            }
        }catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}
