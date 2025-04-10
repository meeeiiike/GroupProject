package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;



public class StudentManagementCreate {

    // Case 1
    // get Department details
    public static void getDepartmentInput(Scanner sc) throws SQLException {

        System.out.println("Enter department name: ");
        String name = sc.nextLine();

        setDepartmentInput(name);
}

    // connect to DB and set Department details
    public static void setDepartmentInput(String name) throws SQLException {
        String departmentInsertSQL = "INSERT INTO department (name) VALUES ('" + name + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(departmentInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */
    // Case 2
    // get Student details
    public static void getStudentInput(Scanner sc) throws SQLException {
        System.out.println("Please enter student department id: ");
        int department_id = sc.nextInt();
            sc.nextLine();

        System.out.println("Please enter student first name: ");
        String first_name = sc.nextLine();

        System.out.println("Please enter student last name: ");
        String last_name = sc.nextLine();

        System.out.println("Please enter student email: ");
        String email = sc.nextLine();

        setStudentInput(department_id, first_name, last_name, email);
    }

    // connect to DB and set Student details
    public static void setStudentInput(int department_id, String first_name, String last_name, String email) throws SQLException {
        String studentInsertSQL = "INSERT INTO student (department_id, first_name, last_name, email) VALUES ('" + department_id + "','" + first_name + "', '" + last_name + "','" + email + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(studentInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */
    // Case 3
    public static void getStaffInput(Scanner sc) throws SQLException {
        System.out.println("Please enter staff first name: ");
        String first_name = sc.nextLine();

        System.out.println("Please enter staff last name: ");
        String last_name = sc.nextLine();

        System.out.println("Please enter staff email: ");
        String email = sc.nextLine();

        System.out.println("Please enter staff phone number: ");
        String phone_number = sc.nextLine();

        System.out.println("Please enter staff office location: ");
        String office_location = sc.nextLine();

        System.out.println("Please enter staff department id: ");
        int department_id = sc.nextInt();
            sc.nextLine();

        setStaffInput(first_name, last_name, email, phone_number, office_location, department_id);
    }

    // connect to DB and set Staff details
    public static void setStaffInput(String first_name, String last_name, String email, String phone_number, String office_location, int department_id) throws SQLException {
        String staffInsertSQL = "INSERT INTO staff ( first_name,  last_name,  email,  phone_number, office_location, department_id) VALUES ('" + first_name + "', '" + last_name + "','" + email + "','" + phone_number + "','" + office_location + "','" + department_id + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(staffInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */
    // Case 4
    // get Course details
    public static void getCourseInput(Scanner sc) throws SQLException {
        System.out.println("Enter course name: ");
        String course_name = sc.nextLine();

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
        int department_id = sc.nextInt();

        System.out.println("Please Choose Staff ID: ");
        int staff_id = sc.nextInt();
            sc.nextLine();

        setCourseInput(course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id);
    }

    // connect to DB and set Staff details
    public static void setCourseInput(String course_name, int credits, int level, int semester, int duration_weeks, int max_students, int department_id, int staff_id) throws SQLException {
        String courseInsertSQL = "INSERT INTO course (course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id) VALUES ('" + course_name + "','" + credits + "', '" + level + "','" + semester + "','" + duration_weeks + "', '" + max_students + "', '" + department_id + "','" + staff_id + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(courseInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */

    // Case 5
    // get Grades details
    public static void getGradesInput(Scanner sc) throws SQLException {
        System.out.println("Please enter student id: ");
        int student_id = sc.nextInt();

        System.out.println("Please enter course id: ");
        int course_id = sc.nextInt();

        System.out.println("Enter level: ");
        int level = sc.nextInt();

        System.out.println("Enter grade: ");
        int grade = sc.nextInt();

        setGradesInput(student_id, course_id, level, grade);
    }

    // connect to DB and set Grades details
    public static void setGradesInput(int student_id, int course_id, int level, int grade) throws SQLException {
        String gradesInsertSQL = "INSERT INTO grades (student_id, course_id, level, grade) VALUES ('" + student_id + "','" + course_id + "', '" + level + "','" + grade + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(gradesInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */

    // Case 6
    // get Payments details
    public static void getPaymentsInput(Scanner sc) throws SQLException {
        System.out.println("Please enter student id: ");
        int student_id = sc.nextInt();

        System.out.println("Please enter course id: ");
        int course_id = sc.nextInt();
            sc.nextLine();

        System.out.println("Enter payment status: ");
        String payment_status = sc.nextLine();

        System.out.println("Enter payment amount: ");
        int payment_amount = sc.nextInt();

        setPaymentsInput(student_id, course_id, payment_status, payment_amount);
    }

    // connect to DB and set payments details
    public static void setPaymentsInput(int student_id, int course_id, String payment_status, int payment_amount) throws SQLException {
        String paymentsInsertSQL = "INSERT INTO payments (student_id, course_id, payment_status, payment_amount) VALUES ('" + student_id + "','" + course_id + "', '" + payment_status + "','" + payment_amount + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(paymentsInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

    /* *************************************************************************************  */
    // Case 7
    // get College address
    public static void getCollege_addressInput(Scanner sc) throws SQLException {
        System.out.println("Please enter department id: ");
        int department_id = sc.nextInt();
            sc.nextLine();

        System.out.println("enter address line 1: ");
        String address_line_1 = sc.nextLine();

        System.out.println("enter address line 2:");
        String address_line_2 = sc.nextLine();

        System.out.println("enter town/city: ");
        String town_city = sc.nextLine();

        System.out.println("enter county: ");
        String county = sc.nextLine();

        setCollege_addressInput(department_id, address_line_1, address_line_2, town_city, county);
    }

    // Connect to DB and set college address details
    public static void setCollege_addressInput(int department_id, String address_line_1, String address_line_2, String town_city, String county) throws SQLException {
        String college_addressInsertSQL = "INSERT INTO college_address (department_id, address_line_1, address_line_2, town_city, county) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(college_addressInsertSQL)) {

            // Set the values to the prepared statement
            preparedStatement.setInt(1, department_id);
            preparedStatement.setString(2, address_line_1);
            preparedStatement.setString(3, address_line_2);
            preparedStatement.setString(4, town_city);
            preparedStatement.setString(5, county);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }
    /* ************************************************************* */

    // Case 8
    // get Student address details
    public static void getStudent_addressInput(Scanner sc) throws SQLException {
        System.out.println("Please enter student id: ");
        int student_id = sc.nextInt();
            sc.nextLine();

        System.out.println("enter address line 1: ");
        String address_line_1 = sc.nextLine();

        System.out.println("enter address line 2:");
        String address_line_2 = sc.nextLine();

        System.out.println("enter town/city: ");
        String town_city = sc.nextLine();

        System.out.println("enter county: ");
        String county = sc.nextLine();

        setStudent_addressInput(student_id, address_line_1, address_line_2, town_city, county);
    }

    // Connect to DB and set student address details
    public static void setStudent_addressInput(int student_id, String address_line_1, String address_line_2, String town_city, String county) throws SQLException {
        String student_addressInsertSQL = "INSERT INTO student_address (student_id, address_line_1, address_line_2, town_city, county) VALUES ('" + student_id + "','" + address_line_1 + "', '" + address_line_2 + "','" + town_city + "', '" + county + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(student_addressInsertSQL);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        }
    }

public static void main(String[] args) throws SQLException {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.print("Select table to insert data: \n");
        System.out.print("1. Department: \n");
        System.out.print("2. Student: \n");
        System.out.print("3. Staff: \n");
        System.out.print("4. Course: \n");
        System.out.print("5. Grades: \n");
        System.out.print("6. Payments: \n");
        System.out.print("7. College Address: \n");
        System.out.print("8. Student Address: \n");
        System.out.print("9. Exit Menu:\n");
        System.out.print("Enter your choice: \n");

        int choice = sc.nextInt();
            sc.nextLine();

        switch (choice) {
            // Get details of department
            case 1:
                getDepartmentInput(sc);
                break;

            // Get details of student
            case 2:
                getStudentInput(sc);
                break;

            // Get details of staff
            case 3:
                getStaffInput(sc);
                break;

            // Get details of course
            case 4:
                getCourseInput(sc);
                break;

            // Get details Grades
            case 5:
                getGradesInput(sc);
                break;

            // Get Payments details
            case 6:
                getPaymentsInput(sc);
                break;

            // Get College address
            case 7:
                getCollege_addressInput(sc);
                break;

             // Get student address details
            case 8:
                getStudent_addressInput(sc);
                break;

            // Exit
            case 9:
                System.out.println("Exit");
                return;

            default:
                System.out.println("Invalid choice");
                return;
            }
        }
    }
}


