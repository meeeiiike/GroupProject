package ie.atu.GroupProject;

import java.sql.*;
import java.util.Scanner;

//TODO: add error msg when we add ID that doesnt exist yet
// add helper method to find last inserted id (Paul has two versions on insert w/transactions
// add transactions
// add same functionality for all switch cases
// test for failure, add exceptions and error logs
// Add connection pool!
// Use Code Coverage to help with Testing! Complexity < 10
// LOTS OF REDUNDANT CODE! once happy with functionality,
// Clean up code to reduce redundancy

public class StudentManagementUpdate {
    public static void main(String[] args){
        // |------------------------------------------------------------------------------------------------------------------------|
        //Start Menu
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while (run) {
            System.out.println("""
                    
                     Welcome to Student Management System!\s
                     You Selected Update
                     \
                    Please Select Table to Update:\s
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
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    updateDepartment(sc);
                    break;
                case 2:
                    updateStudent(sc);
                    break;
                case 3:
                    updateStaff(sc);
                    break;
                case 4:
                    updateCourse(sc);
                    break;
                case 5:
                    updateGrades(sc);
                    break;
                case 6:
                    updatePayment(sc);
                    break;
                case 7:
                    updateCollege(sc);
                    break;
                case 8:
                    updateAddress(sc);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Error Occurred");
            }
        }
    }
    private static void updateDepartmentRefactor(String name,int departmentID) {
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id =" + departmentID);
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            // TODO: include when id>0 BUT not assigned to anything
            if (rowsUpdated <= 0) {
                throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    private static void updateDepartment(Scanner sc){
        System.out.println("Update Department\nPlease enter ID: ");
        int departmentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String name = sc.nextLine();
        updateDepartmentRefactor(name, departmentID);
    }
    private static void updateStudent(Scanner sc) {
    System.out.println("Update Student\nPlease enter ID: ");
        int studentID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student SET first_name = ?, last_name = ?, email = ?, department_id = ? WHERE student_id = " + studentID);
            System.out.println("Enter first name: ");
            String first_name = sc.next();
            System.out.println("Enter last name: ");
            String last_name = sc.next();
            System.out.println("Enter email: ");
            String email = sc.next();
            System.out.println("Please Choose Department ID: ");
            int departmentID = sc.nextInt();
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setInt(4, departmentID);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
    private static void updateStaff(Scanner sc) {
        System.out.println("Update staff\nPlease enter ID: ");
        int staffID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE staff SET first_name = ?, last_name = ?, email = ?, phone_number = ?, office_location = ?, department_id = ? WHERE staff_id = " + staffID);
            System.out.println("Enter first name: ");
            String first_name = sc.next();
            System.out.println("Enter last name: ");
            String last_name = sc.next();
            System.out.println("Enter email: ");
            String email = sc.next();
            System.out.println("Enter phone: ");
            String phone = sc.next();
            System.out.println("Enter office: ");
            String office = sc.next();
            System.out.println("Please Choose Department ID: ");
            int departmentID = sc.nextInt();
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, office);
            stmt.setInt(6, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
    private static void updateCourse(Scanner sc) {
        System.out.println("Update Course\nPlease enter ID: ");
        int courseID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE course SET course_name = ?, credits = ?, level = ?, semester = ?, duration_weeks = ?,  max_students = ?, department_id = ?, staff_id =? WHERE course_id = " + courseID);
            System.out.println("Enter course name: ");
            String course_name = sc.next();
            System.out.println("Enter credits: ");
            int credits = sc.nextInt();
            System.out.println("Enter level: ");
            int level = sc.nextInt();
            System.out.println("Enter semester: ");
            int semester = sc.nextInt();
            System.out.println("Enter duration in weeks: ");
            int duration_weeks = sc.nextInt();
            System.out.println("Enter Max Students: ");
            int max_students = sc.nextInt();
            System.out.println("Please Choose Department ID: ");
            int departmentID = sc.nextInt();
            System.out.println("Please Choose Staff ID: ");
            int staffID = sc.nextInt();

            stmt.setString(1, course_name);
            stmt.setInt(2, credits);
            stmt.setInt(3, level);
            stmt.setInt(4, semester);
            stmt.setInt(5, duration_weeks);
            stmt.setInt(6, max_students);
            stmt.setInt(7, departmentID);
            stmt.setInt(8, staffID);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
    private static void updateGrades(Scanner sc) {
        System.out.println("Update Grades\nPlease enter ID: ");
        int gradeID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE grades SET level = ?, grade =?, student_id =?, course_id = ? WHERE grade_id = " + gradeID);
            System.out.println("Enter level: ");
            int level = sc.nextInt();
            System.out.println("Enter grade: ");
            int grade = sc.nextInt();
            System.out.println("Enter student ID: ");
            int studentID = sc.nextInt();
            System.out.println("Enter course ID: ");
            int courseID = sc.nextInt();

            stmt.setInt(1, level);
            //Refactored to reduce some code
            setGradeStudentCourseID(stmt, grade, studentID, courseID);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }

    private static void updatePayment(Scanner sc) {
        System.out.println("Update Payments\nPlease enter ID: ");
        int paymentID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE payments SET payment_status = ?, payment_amount =?, student_id =?, course_id = ? WHERE payment_id = " + paymentID);
            System.out.println("Enter payment status: ");
            String paymentStatus = sc.next();
            System.out.println("Enter Amount: ");
            int paymentAmount = sc.nextInt();
            System.out.println("Enter student ID: ");
            int studentID = sc.nextInt();
            System.out.println("Enter course ID: ");
            int courseID = sc.nextInt();

            stmt.setString(1, paymentStatus);
            setGradeStudentCourseID(stmt, paymentAmount, studentID, courseID);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
    private static void updateCollege(Scanner sc) {
        System.out.println("Update College\nPlease enter ID: ");
        int collegeAddressID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE college_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, department_id = ? WHERE college_address_id = " + collegeAddressID);
            System.out.println("Enter Address Line 1: ");
            String addressLine1 = sc.next();
            System.out.println("Enter Address Line 2: ");
            String addressLine2 = sc.next();
            System.out.println("Enter Town OR City: ");
            String townCity = sc.next();
            System.out.println("Enter County: ");
            String county = sc.next();
            System.out.println("Enter Department ID: ");
            GetAddressDetails(sc, stmt, addressLine1, addressLine2, townCity, county);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }

    private static void updateAddress(Scanner sc) {
        System.out.println("Update Address\nPlease enter ID: ");
        int studentAddressID = sc.nextInt();
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, student_id = ? WHERE student_address_id = " + studentAddressID);
            System.out.println("Enter Address Line 1: ");
            String addressLine1 = sc.next();
            System.out.println("Enter Address Line 2: ");
            String addressLine2 = sc.next();
            System.out.println("Enter Town OR City: ");
            String townCity = sc.next();
            System.out.println("Enter County: ");
            String county = sc.next();
            System.out.println("Enter Student ID: ");
            GetAddressDetails(sc, stmt, addressLine1, addressLine2, townCity, county);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
    // Refactored reduces some redundancy
    private static void GetAddressDetails(Scanner sc, PreparedStatement stmt, String addressLine1, String addressLine2, String townCity, String county) throws SQLException {
        int departmentID = sc.nextInt();

        stmt.setString(1, addressLine1);
        stmt.setString(2, addressLine2);
        stmt.setString(3, townCity);
        stmt.setString(4, county);
        stmt.setInt(5, departmentID);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated <= 0) {
            throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
        }
        System.out.println("Rows Updated Successfully: " + rowsUpdated);
    }
    //Refactored to reduce some code
    private static void setGradeStudentCourseID(PreparedStatement stmt, int grade, int studentID, int courseID) throws SQLException {
        stmt.setInt(2, grade);
        stmt.setInt(3, studentID);
        stmt.setInt(4, courseID);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated <= 0) {
            throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
        }
        System.out.println("Rows Updated Successfully: " + rowsUpdated);
    }
}




