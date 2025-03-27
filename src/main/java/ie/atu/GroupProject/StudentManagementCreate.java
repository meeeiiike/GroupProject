package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties; // greyed out so its likely unused, (should) be safe to omit these. Should being key word lol
import java.util.Scanner;

/*
* WHEN YOU GET ON: first task should be to create failure test for department.
* from there you needto write success/ failure (same format as your department Success test) for the rest of the tables
* and you'll also need to refactor this create class, following same format as we did
*
 */
//Class format:
// psvm
// menu, grab user input
// call switch() pass user input
// case 1: will call StudentManagementCreate.getDepartmentInput(sc);
// rest of cases will handle rest of tables and dont forget option to exit program
// try not stress it too much, focus on functionality first, we can always clean it up and make changes AFTER everythings working and of course just shout me if any issues at all

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
                // throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
        }
    }

    /* *************************************************************************************  */
    // Case 2
    // get Student details
    public static void getStudentInput(Scanner sc) throws SQLException {

        System.out.println("Please enter student department id: ");
        int department_id = sc.nextInt();

        Scanner first_nameInput = new Scanner(System.in);
        System.out.println("Please enter student first name: ");
        String first_name = first_nameInput.nextLine();

        Scanner last_nameInput = new Scanner(System.in);
        System.out.println("Please enter student last name: ");
        String last_name = last_nameInput.nextLine();

        Scanner emailInput = new Scanner(System.in);
        System.out.println("Please enter student email: ");
        String email = emailInput.nextLine();

        String studentInsertSQL = "INSERT INTO student (department_id, first_name, last_name, email) VALUES ('" + department_id + "','" + first_name + "', '" + last_name + "','" + email + "')";
        String name = sc.nextLine();
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
                //  throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
        }
    }


    /* *************************************************************************************  */
    // Case 3
    public static void getStaffInput(Scanner sc) throws SQLException {
        Scanner first_nameInput = new Scanner(System.in);
        System.out.println("Please enter staff first name: ");
        String first_name = first_nameInput.nextLine();
        //String = first_nameInput.nextLine();

        Scanner last_nameInput = new Scanner(System.in);
        System.out.println("Please enter staff last name: ");
        String last_name = last_nameInput.nextLine();

        Scanner emailInput = new Scanner(System.in);
        System.out.println("Please enter staff email: ");
        String email = emailInput.nextLine();

        Scanner phone_numberInput = new Scanner(System.in);
        System.out.println("Please enter staff phone number: ");
        String phone_number = phone_numberInput.nextLine();

        Scanner office_locationInput = new Scanner(System.in);
        System.out.println("Please enter staff office location: ");  //college_address_id???
        String office_location = office_locationInput.nextLine();

       // Scanner department_idInput = new Scanner(System.in);
        System.out.println("Please enter staff department id: ");
        int department_id = sc.nextInt();
        //int department_id = department_idInput = sc.nextInt();

        //setStaffInput(first_name, last_name, email, phone_number, office_location, int department_id,) throws SQLException {
        String staffInsertSQL = "INSERT INTO staff ( first_name,  last_name,  email,  phone_number, office_location, department_id) VALUES ('" + first_name + "', '" + last_name + "','" + email + "','" + phone_number + "','" + office_location + "','" + department_id + "')";
        //String name = sc.nextLine();
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
        } //catch (SQLException e) {
          //  e.printStackTrace();
        }
    //}
//}

    /* *************************************************************************************  */
    // Case 4
    // get Course details
    public static void getCourseInput(Scanner sc) throws SQLException {
        Scanner course_nameInput = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String course_name = course_nameInput.nextLine();

        System.out.println("Enter credits: ");
        int credits = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter level: ");
        int level = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter semester: ");
        int semester = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter duration in weeks: ");
        int duration_weeks = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Max Students: ");
        int max_students = sc.nextInt();
        sc.nextLine();

        System.out.println("Please Choose Department ID: ");
        int department_id = sc.nextInt();
        sc.nextLine();

        System.out.println("Please Choose Staff ID: ");
        int staff_id = sc.nextInt();
       // sc.nextLine();

        String courseInsertSQL = "INSERT INTO course (course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id) VALUES ('" + course_name + "','" + credits + "', '" + level + "','" + semester + "','" + duration_weeks + "', '" + max_students + "', '" + department_id + "','" + staff_id + "')";
        String name = sc.nextLine();
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
                //  throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
        }
    }

    /* *************************************************************************************  */

        // Case 5
    // get Grades details
    public static void getGradesInput(Scanner sc) throws SQLException {
        Scanner gradesInput = new Scanner(System.in);

        System.out.println("Please enter student id: ");
        int student_id = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter course id: ");
        int course_id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter level: ");
        int level = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter grade: ");
        int grade = sc.nextInt();
       // sc.nextLine();

        String gradesInsertSQL = "INSERT INTO grades (student_id, course_id, level, grade) VALUES ('" + student_id + "','" + course_id + "', '" + level + "','" + grade + "')";
        String name = sc.nextLine();

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






    // Try follow same format for rest of your tables, will leave examples below. any issues just shout me

    // getStudentDetails
    // setStudentDetails
    // so on so on all your methods
    //public static void main
    // menu
    // take in input, pass to swtch
    // now your cases will only have to call the SET method which handles connecting to DB and setting details

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
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            int rowsAffected; //shouldnt need this as its in the methods


            sc.nextLine();


                switch (choice) {

                    // Get details of department
                    case 1: getDepartmentInput(sc);

                        break;

                    // Get details of student
                    case 2: getStudentInput(sc);

                        break;

                    // Get details of staff
                    case 3: getStaffInput(sc);

                        break;

                    // Get details of course
                    case 4: getCourseInput(sc);

                        break;

                    // Get details Grades
                    case 5: getGradesInput(sc);

                        break;
/*
                    case 8:

                        // Get details of student address
                        Scanner studentidInput = new Scanner(System.in);
                        System.out.println("Please enter student id: ");
                        student_id = studentidInput.nextLine();

                        Scanner studentln1Input = new Scanner(System.in);
                        System.out.println("Please enter address line 1: ");
                        line1 = studentln1Input.nextLine();

                        Scanner studentln2Input = new Scanner(System.in);
                        System.out.println("Please enter address line 2: ");
                        line2 = studentln2Input.nextLine();

                        Scanner studentToCiInput = new Scanner(System.in);
                        System.out.println("Please enter town/city: ");
                        town_city = studentToCiInput.nextLine();

                        Scanner studentadCInput = new Scanner(System.in);
                        System.out.println("Please enter county: ");
                        county = studentadCInput.nextLine();

                        String S_addressInsertSQL = "INSERT INTO student_address (student_id, address_line_1, address_line_2, town_city, county) VALUES ('" + student_id + "', '" + line1 + "','" + line2 + "', '" + town_city + "','" + county + "')";

                        try (Connection connection = DriverManager.getConnection(url, username, password);
                             Statement statement = connection.createStatement()) {

                            // Execute the insert query
                            rowsAffected = statement.executeUpdate(S_addressInsertSQL);

                            if (rowsAffected > 0) {
                                System.out.println("Record inserted successfully.");
                            } else {
                                System.out.println("Failed to insert record.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

*/
                    default:
                        System.out.println("Invalid choice");
                        return;

                }

            }
        }
    }


