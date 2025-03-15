package ie.atu.GroupProject;

import java.util.Scanner;

public class StudentManagementDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

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
            scanner.nextLine(); // Consume newline

            if (choice == 9) {
                System.out.println("Exiting...");
                continueRunning = false;
            } else {
                System.out.println("Feature not yet implemented.");
            }
        }
    }
}
