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
                        System.out.println("Enter department ID to delete: ");
                        int departmentID = scanner.nextInt();
                        try {
                            deleteDepartment(departmentID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error: Unable to delete department,");
                        }
                        break;
                    case 2:
                        System.out.println("Enter student ID to delete: ");
                        int studentID = scanner.nextInt();
                        try {
                            deleteStudent(studentID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error: Read above");
                        }
                        break;
                    case 3:
                        System.out.println("Enter staff ID to delete");
                        int staffID = scanner.nextInt();
                        try {
                            deleteStaff(staffID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error: Read above");
                        }
                        break;
                    case 4:
                        System.out.println("Enter course ID to delete");
                        int courseID = scanner.nextInt();
                        try {
                            deleteCourse(courseID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error: Read above");
                        }
                        break;
                    case 5:
                        System.out.println("Enter grade ID to delete");
                        int gradeID = scanner.nextInt();
                        try {
                            deleteGrade(gradeID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error");
                        }
                        break;
                    case 6:
                        System.out.println("Enter payment ID to delete");
                        int paymentID = scanner.nextInt();
                        try {
                            deletePayment(paymentID);
                        }
                        catch (SQLException e){
                            System.out.println("Database Error");
                        }
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

    public static void deleteDepartment(int departmentID) throws SQLException {
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM department WHERE department_id =" + departmentID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The department id of " + departmentID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + departmentID + "from department table");
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Cannot delete department because it is referenced in other tables.");
            throw new  SQLIntegrityConstraintViolationException("Error: Cannot delete department because it is referenced in other tables.");
        }
    }

    public static void deleteStudent(int studentID) throws SQLException {
        try (Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE student_id =" + studentID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The student id of " + studentID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + studentID + " from student table");
            }
        }
        catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Error: Cannot delete student because it is referenced in other tables.");
            throw new  SQLIntegrityConstraintViolationException("Error: Cannot delete student because it is referenced in other tables.");
        }
    }

    public static void deleteStaff(int staffID) throws SQLException  {
        try (Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM staff WHERE staff_id =" + staffID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The staff id of " + staffID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + staffID + " from staff table");
            }

        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Error: Cannot delete staff because it is referenced in other tables.");
            throw new SQLIntegrityConstraintViolationException("Error: Cannot delete staff because it is referenced in other tables.");
        }
    }

    public static void deleteCourse(int courseID) throws SQLException {
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM course WHERE course_id =" + courseID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The course id of " + courseID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + courseID + " from course table");
            }

        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Error: Cannot delete course because it is referenced in other tables.");
            throw new SQLIntegrityConstraintViolationException("Error: Cannot delete course because it is referenced in other tables.");
        }
    }

    public static void deleteGrade(int gradeID) throws SQLException {
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM grades WHERE grade_id=" + gradeID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The grade id of " + gradeID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + gradeID + " from grade table");
            }
        }
    }

    public static void deletePayment(int paymentID) throws SQLException {
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM payments WHERE payment_id=" + paymentID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated <= 0){
                System.out.println("The payment id of " + paymentID + " was not found");
            }
            else {
                System.out.println("Successfully deleted id " + paymentID + " from payment table");
            }
        }
    }
}
