package ie.atu.GroupProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Basic idea for main class
        // start loop, take in operation,
        // then take in which table to use operation
        // implement features based on user input
        // run until user exits

        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while (run){
            System.out.println("    |Please Select Operation|\n 1. Create\n 2. Read\n 3. Update \n 4. Delete\n 5. Exit ");
            int input = sc.nextInt();
            sc.nextLine();
            System.out.println("\n Welcome to Student Management System! \n You Selected Update\n " +
                    "Please Select Table to Update: \n1. Department\n2. Student\n3. Staff\n4. Course\n" +
                    "5. Grades\n6. Payment\n7. College\n8. Address\n9. Exit\n Please Enter: ");

            // unsure of this layout as i think this will cause a lot
            // of redundant code. i think the switch statements should
            // just call the corresponding function which will make our
            // main class a lot cleaner and easier to look at
            switch (input){
                case 1:
                    System.out.println("You Selected Create");
                    // take input for which table to select.
                    // call switch stmt based on input
                    // this way i think is really bad, but it's okay as temp
                    break;
                case 2:
                    System.out.println("You Selected Read");
                    break;
                case 3:
                    System.out.println("You Selected Update");
                    break;
                case 4:
                    System.out.println("You Selected Delete");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Error");

            }
        }
    }
}