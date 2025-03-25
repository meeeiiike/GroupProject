package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class StudentManagementCreate {
    public static void getdepartmentInput(Scanner sc) throws SQLException {

        System.out.println("Enter department name: ");
        String name = sc.nextLine();

        setDepartmentInput(name);
    }

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
            } catch (SQLException e) {
                e.printStackTrace();
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
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            int rowsAffected;


            sc.nextLine();

            String name;
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
            String office_location;


                switch (choice) {
                    case 1: getdepartmentInput(sc);

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

                  /*  case 2:
                        // Get details of student

                        Scanner department_idInput = new Scanner(System.in);
                        System.out.println("Please enter student department id: ");
                        department_id = department_idInput.nextLine();

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

                        try (Connection connection = DriverManager.getConnection(url, username, password);
                             Statement statement = connection.createStatement()) {

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


