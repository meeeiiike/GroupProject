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
            System.out.println("""
                    \nPlease Select Table:\s
                    1. Department
                    2. Student
                    3. Staff
                    4. Course
                    5. Grades
                    6. Payment
                    7. College
                    8. Address
                    9. Exit
                     Please Enter:\s""");
            int inputTable = sc.nextInt();
            sc.nextLine();
            switch (inputCrud){
                case 1:
                    System.out.println("You Selected Create");
                    //call your class
                    // fergal, once your SmsCreate class is all changed, you should be able to call the methods the same as me. example -> case 1: StudentManagementCreate.getDepartmentInput(sc);
                    // we call the set details method as this is the method which asks the user for the info, then at the end of the method it calls the second method, which SETs the details after connecting to the DB
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