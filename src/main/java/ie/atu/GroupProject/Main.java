package ie.atu.GroupProject;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while (run){
            System.out.println("\n Welcome to Student Management System!\n Please Select Operation\n\n 1. Create\n 2. Read\n 3. Update \n 4. Delete\n 5. Exit ");
            int inputCrud = sc.nextInt();
            sc.nextLine();
            if(inputCrud == 5){
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("Please Select Table: \n1. Department\n2. Student\n3. Staff\n4. Course\n" +
                    "5. Grades\n6. Payment\n7. College\n8. Address\n9. Exit\n Please Enter: ");
            int inputTable = sc.nextInt();
            sc.nextLine();
            switch (inputCrud){
                case 1:
                    System.out.println("You Selected Create");
                    //call your class
                    break;
                case 2:
                    System.out.println("You Selected Read");
                    //call your class
                    break;
                case 3:
                    System.out.println("You Selected Update");
                    switch(inputTable) {
                        case 1: StudentManagementUpdate.getDepartmentDetails(sc);
                            break;
                        case 2: StudentManagementUpdate.getStudentDetails(sc);
                            break;
                        case 3:StudentManagementUpdate.getStaffDetails(sc);
                            break;
                        case 4:StudentManagementUpdate.getCourseDetails(sc);
                            break;
                        case 5:StudentManagementUpdate.getGradeDetails(sc);
                            break;
                        case 6:StudentManagementUpdate.getPaymentDetails(sc);
                            break;
                        case 7:StudentManagementUpdate.getCollegeDetails(sc);
                            break;
                        case 8:StudentManagementUpdate.getAddressDetails(sc);
                            break;
                        case 9:
                            System.out.println("Goodbye!");
                            run = false;
                            break;
                        default: System.out.println("Error");
                    }
                    break;
                case 4:
                    System.out.println("You Selected Delete");
                    //call your class
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