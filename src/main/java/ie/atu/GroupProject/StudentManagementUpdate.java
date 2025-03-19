package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//TODO: add error msg when we add ID that doesnt exist yet
// add same functionality for all switch cases
// test for failure, add exceptions and error logs
// Add connection pool!
// Use Code Coverage to help with Testing! Complexity < 10
// LOTS OF REDUNDANT CODE! once happy with functionality,
// Clean up code to reduce redundancy

public class StudentManagementUpdate {

    public static void main(String[] args){

        // |------------------------------------------------------------------------------------------------------------------------|
        // Get database properties
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
        // |------------------------------------------------------------------------------------------------------------------------|

        // |------------------------------------------------------------------------------------------------------------------------|
        //Start Menu
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("\n Welcome to Student Management System! \n You Selected Update\n " +
                    "Please Select Table to Update: \n1. Department\n2. Student\n3. Staff\n4. Course\n" +
                    "5. Grades\n6. Payment\n7. College\n8. Address\n9. Exit\n Please Enter: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    updateDepartment(sc);
                    break;
                case 2:
                    System.out.println("Update Student\nPlease enter ID: ");
                    int studentID = sc.nextInt();
                    try (Connection con = DriverManager.getConnection(url, username, password)) {
                        PreparedStatement stmt = con.prepareStatement("UPDATE student SET first_name = ?, last_name = ?, email = ? WHERE student_id = " + studentID);
                        System.out.println("Enter first name: ");
                        String first_name = sc.next();
                        System.out.println("Enter last name: ");
                        String last_name = sc.next();
                        System.out.println("Enter email: ");
                        String email = sc.next();
                        stmt.setString(1, first_name);
                        stmt.setString(2, last_name);
                        stmt.setString(3, email);
                        int rowsUpdated = stmt.executeUpdate();
                        System.out.println("Rows Updated Successfully: " + rowsUpdated);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Could not Connect");
                    }
                    break;
                case 3:
                    System.out.println("Update staff\nPlease enter ID: ");
                    int staffID = sc.nextInt();
                    try (Connection con = DriverManager.getConnection(url, username, password)) {
                        PreparedStatement stmt = con.prepareStatement("UPDATE staff SET first_name = ?, last_name = ?, email = ?, phone_number = ?, office_location = ? WHERE staff_id = " + staffID);
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
                        stmt.setString(1, first_name);
                        stmt.setString(2, last_name);
                        stmt.setString(3, email);
                        stmt.setString(4, phone);
                        stmt.setString(5, office);

                        int rowsUpdated = stmt.executeUpdate();
                        System.out.println("Rows Updated Successfully: " + rowsUpdated);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Could not Connect");
                    }
                    break;
                case 4:
                    System.out.println("Update Course\nPlease enter ID: ");
                    int courseID = sc.nextInt();
                    try (Connection con = DriverManager.getConnection(url, username, password)) {
                        PreparedStatement stmt = con.prepareStatement("UPDATE course SET course_name = ?, credits = ?, level = ?, semester = ?, duration_weeks = ?,  max_students = ? WHERE course_id = " + courseID);
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

                        stmt.setString(1, course_name);
                        stmt.setInt(2, credits);
                        stmt.setInt(3, level);
                        stmt.setInt(4, semester);
                        stmt.setInt(5, duration_weeks);
                        stmt.setInt(6, max_students);

                        int rowsUpdated = stmt.executeUpdate();
                        System.out.println("Rows Updated Successfully: " + rowsUpdated);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Could not Connect");
                    }
                    break;

                //TODO write test units FIRST for rest of switch cases, then add test units for existing code
                case 5:
                    System.out.println("Update Grades");
                    break;
                case 6:
                    System.out.println("Update Payment");
                    break;
                case 7:
                    System.out.println("Update College");
                    break;
                case 8:
                    System.out.println("Update Address");
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

    private static void updateDepartment(Scanner sc){

        // TODO: fix dbProps loading issue where i have to include in every method to reduce redundancy
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

        //Connects using db.properties,
        //Uses prepare stmt to write query to update dept name at corresponding ID,
        System.out.println("Update Department\nPlease enter ID: ");
        int departmentID = sc.nextInt();
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            System.out.println("Enter new name: ");
            String name = sc.next();
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();

            // simple error handling
            // TODO: include when id>0 BUT not assigned to anything
            if (rowsUpdated <= 0) {
                throw new SQLException("ID INVALID: must be > 0");
            }
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect");

        }
    }
}




