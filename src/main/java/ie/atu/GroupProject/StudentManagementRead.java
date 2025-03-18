package ie.atu.GroupProject;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class StudentManagementRead {
    public static void main(String[] args) {
        Properties dbProps = new Properties();
        try (InputStream input = TestConnection.class.getResourceAsStream("/db.properties")) {
            if (input == null) {
                System.out.println("Unable to find db.properties");
                return;
            }
            dbProps.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the table you want to read from: \n");
            System.out.print("1. Department: \n");
            System.out.print("2. Student: \n");
            System.out.print("3. Staff: \n");
            System.out.print("4. Course: \n ");
            System.out.print("5. Grades: \n");
            System.out.print("6. Payment: \n");
            System.out.print("7. College: \n");
            System.out.print("8. Address: \n");
            System.out.print("9. Exit: \n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            String selectSQL = "";


            switch (choice) {
                case 1:
                    System.out.print("Enter department ID:");
                    int depId = sc.nextInt();
                    selectSQL = "Select * from department where departmentID = " + depId;
                    break;

                case 2:
                     System.out.print("Enter student ID:");
                     int stuId = sc.nextInt();
                     selectSQL = "Select * from student where studentID = " + stuId;
                     break;
                case 3:
                    System.out.print("Enter staff ID:");
                    int staffId = sc.nextInt();
                    selectSQL = "Select * from staff where staffID = " + staffId;
                    break;
                case 4:
                    System.out.print("Enter course ID:");
                    int courseId = sc.nextInt();
                    selectSQL = "Select * from course where courseID = " + courseId;
                    break;
                case 5:
                    System.out.print("Enter grade ID:");
                    int gradeId = sc.nextInt();
                    selectSQL = "Select * from grades where grade = " + gradeId;
                    break;
                case 6:
                    System.out.print("Enter Payment ID:");
                    int paymentId = sc.nextInt();
                    selectSQL = "Select * from address where addressID = " + paymentId;
                    break;
                case 7:
                    System.out.print("Enter college ID:");
                    int collegeId = sc.nextInt();
                    selectSQL = "Select * from college where collegeID = " + collegeId;
                    break;
                case 8:
                    System.out.print("Enter address ID:");
                    int addressId = sc.nextInt();
                    selectSQL = "Select * from address where addressID = " + addressId;
                    break;
                case 9:
                    System.out.print("Goodbye:)");
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }


        }



    }

}
