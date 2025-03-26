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

    // get Department Details
    public static void getDepartmentInput(Scanner sc) throws SQLException {
        System.out.println("Enter department name: ");
        String name = sc.nextLine();
        setDepartmentInput(name);
    }
    // connect to DB and SET Department details
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
    // get Department Details
    public static void getStudentInput(Scanner sc) throws SQLException {
        Scanner getdepartment_idInput = new Scanner(System.in);
        System.out.println("Please enter student department id: ");
       // String department_id = getdepartment_idInput.nextLine();
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

    // connect to DB and SET details
    public static void setStudentInput(int department_id, String first_name, String last_name, String email) throws SQLException {
        String studentInsertSQL = "INSERT INTO student (department_id, first_name, last_name, email) VALUES ('" + department_id + "','" + first_name + "', '" + last_name + "','" + email + "')";
        try (Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            // Execute the insert query
            int rowsAffected = statement.executeUpdate(studentInsertSQL);
            if  (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
              //  throw new SQLException("ID INVALID: must be > 0 AND must be assigned already");
            }
        }
    }


    /* *************************************************************************************  */

/*
    Scanner getdepartment_idInput = new Scanner(System.in);
                                        System.out.println("Please enter student department id: ");
                    department_id = getdepartment_idInput.nextLine();

                    Scanner first_nameInput = new Scanner(System.in);
                                        System.out.println("Please enter student first name: ");
                    first_name = first_nameInput.nextLine();

                    Scanner last_nameInput = new Scanner(System.in);
                                        System.out.println("Please enter student last name: ");
                    last_name = last_nameInput.nextLine();

                    Scanner emailInput = new Scanner(System.in);
                                        System.out.println("Please enter student email: ");
                    email = emailInput.nextLine();

                    String studentInsertSQL = "INSERT INTO student (department_id, first_name, last_name, email) VALUES ('" + department_id + "','" + first_name + "', '" + last_name + "','" + email + "')";


                                    try (Connection connection = DbUtils.getConnection()){
                        //try (Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();

                        // Execute the insert query

                        rowsAffected = statement.executeUpdate(studentInsertSQL);

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
    /* *************************************************************************************  */



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

            /*String name;            // shouldnt need any these as theyre in the methods
            String department_id;
            String first_name;
            String last_name;
            String email;
            String student_id;
            String line1;
            String line2;
            String town_city;
            String county;
            String phone_number;
            String office_location;*/


                switch (choice) {
                    case 1: getDepartmentInput(sc);

               /*     // Get name of department
                    Scanner departmentInput = new Scanner(System.in);
                    System.out.println("Please enter department name: ");
                    name = departmentInput.nextLine();

                    String departmentInsertSQL = "INSERT INTO department (name) VALUES ('" + name + "')";
                    try (Connection connection = DbUtils.getConnection()) {
                    Statement statement = connection.createStatement()) {

                    // Execute the insert query

                     rowsAffected = statement.executeUpdate(departmentInsertSQL);

                    if (rowsAffected > 0) {
                        System.out.println("Record inserted successfully.");
                    } else {
                        System.out.println("Failed to insert record.");
                    }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                */
                       break;

                   case 2: getStudentInput(sc);
                        // Get details of student

                       /*
                        Scanner getdepartment_idInput = new Scanner(System.in);
                        System.out.println("Please enter student department id: ");
                        department_id = getdepartment_idInput.nextLine();

                        Scanner first_nameInput = new Scanner(System.in);
                        System.out.println("Please enter student first name: ");
                        first_name = first_nameInput.nextLine();

                        Scanner last_nameInput = new Scanner(System.in);
                        System.out.println("Please enter student last name: ");
                        last_name = last_nameInput.nextLine();

                        Scanner emailInput = new Scanner(System.in);
                        System.out.println("Please enter student email: ");
                        email = emailInput.nextLine();

                        String studentInsertSQL = "INSERT INTO student (department_id, first_name, last_name, email) VALUES ('" + department_id + "','" + first_name + "', '" + last_name + "','" + email + "')";


                    try (Connection connection = DbUtils.getConnection()){
                    //try (Connection connection = DriverManager.getConnection(url, username, password);
                             Statement statement = connection.createStatement();

                            // Execute the insert query

                            rowsAffected = statement.executeUpdate(studentInsertSQL);

                            if (rowsAffected > 0) {
                                System.out.println("Record inserted successfully.");
                            } else {
                                System.out.println("Failed to insert record.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }


                        */
                       break;

                    case 3:
                        // Get details of staff

                   /* Scanner staffInput = new Scanner(System.in);
                    System.out.println("Please enter staff department id: ");
                    department_id = department_idInput.nextLine();

                        Scanner firstnameInput = new Scanner(System.in);
                        System.out.println("Please enter staff first name: ");
                        first_name = firstnameInput.nextLine();

                        Scanner lastnameInput = new Scanner(System.in);
                        System.out.println("Please enter staff last name: ");
                        last_name = lastnameInput.nextLine();

                        Scanner staffemailInput = new Scanner(System.in);
                        System.out.println("Please enter staff email: ");
                        email = staffemailInput.nextLine();

                        Scanner phone_numberInput = new Scanner(System.in);
                        System.out.println("Please enter staff phone number: ");
                        phone_number = phone_numberInput.nextLine();

                        Scanner office_locationInput = new Scanner(System.in);
                        System.out.println("Please enter staff office location: ");  //college_address_id???
                        office_location = office_locationInput.nextLine();

                        Scanner departmentidInput = new Scanner(System.in);
                        System.out.println("Please enter staff department: ");
                        department_id = departmentidInput.nextLine();


                        String staffInsertSQL = "INSERT INTO staff (first_name, last_name, email, phone_number, office_location ,department_id) VALUES ('" + first_name + "', '" + last_name + "','" + email + "','" + phone_number + "','" + office_location + "','" + department_id + "')";

                        try (Connection connection = DriverManager.getConnection(url, username, password);
                             Statement statement = connection.createStatement()) {

                            // Execute the insert query

                            rowsAffected = statement.executeUpdate(staffInsertSQL);

                            if (rowsAffected > 0) {
                                System.out.println("Record inserted successfully.");
                            } else {
                                System.out.println("Failed to insert record.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

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


                    default:
                        System.out.println("Invalid choice");
                        return;
                        */
                }

            }
        }
    }


