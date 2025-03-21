package ie.atu.GroupProject;

import java.sql.*;
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

                switch (choice){
                    case 1:
                        deleteDepartment(scanner);
                        break;
                    case 2:
                        deleteStudent(scanner);
                        break;
                    case 3:
                        System.out.println("Staff called");
                        break;
                    case 4:
                        System.out.println("Course called");
                        break;
                    case 5:
                        System.out.println("Grade called");
                        break;
                    case 6:
                        System.out.println("Payment called");
                        break;
                    case 7:
                        System.out.println("College called");
                        break;
                    case 8:
                        System.out.println("Address called");
                        break;
                    case 9:
                        continueRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option or feature not yet implemented");
                }

            }
        }catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public static void deleteDepartment(Scanner scanner) {
        System.out.print("Enter department ID to delete: ");
        int departmentID = scanner.nextInt();
        scanner.nextLine();

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM department WHERE department_id =" + departmentID);
            System.out.println("Successfully deleted id " + departmentID + " from department table.");
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated <= 0){
                System.out.println("The department id of " + departmentID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + departmentID + " from department table.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Cannot delete department because it is referenced in other tables (e.g., Course, Staff, Student, College Address).");
            System.out.println("Delete the related records first before deleting this department.");
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to delete department.");
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE student_id =" + studentID);
            System.out.println("Successfully student id " + studentID + " from department table.");
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated <= 0){
                System.out.println("The student id of " + studentID + " was not found");
            }
            else {
                System.out.println("Successfully student id " + studentID + " from department table.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Cannot delete student because it is referenced in other tables (e.g., Grades, Payments, and Address).");
            System.out.println("Delete the related records first before deleting this student.");
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to delete student.");
            e.printStackTrace();
        }
    }
}
