package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class StudentManagementCreate {
    public static void main(String[] args) {

        Properties dbProps = new Properties();
        try (InputStream input = TestConnection.class.getResourceAsStream("/db.properties")) {
            if (input == null) {
                System.out.println("Unable to find db.properties");
                return;
            }
            dbProps.load(input);
        } catch (IOException e) {
            e.printStackTrace();            // Print stack trace of the exception to console
            return;
        }
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the table you want to insert data to: \n");
            System.out.print("1. Department: \n");
            System.out.print("2. Student: \n");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            String selectSQL = "";
            String name = null;
            String studentId = null;
            String line1 = null;
            String line2 = null;
            String town_city = null;
            String county = null;


            switch (choice) {
                case 1:
                    // Get name of department
                    Scanner departmentInput = new Scanner(System.in);
                    System.out.println("Please enter department name: ");
                    name = departmentInput.nextLine();
                    break;

                case 2:
                    // Get details of student
                    Scanner studentidInput = new Scanner(System.in);
                    System.out.println("Please enter student id: ");
                    studentId = studentidInput.nextLine();

                    Scanner studentln1Input = new Scanner(System.in);
                    System.out.println("Please enter student address line 1: ");
                    line1 = studentln1Input.nextLine();

                    Scanner studentln2Input = new Scanner(System.in);
                    System.out.println("Please enter student address line 2: ");
                    line2 = studentln2Input.nextLine();

                    Scanner studentToCiInput = new Scanner(System.in);
                    System.out.println("Please enter student address town/city: ");
                    town_city = studentToCiInput.nextLine();

                    Scanner studentadCInput = new Scanner(System.in);
                    System.out.println("Please enter student address town/city: ");
                    county = studentadCInput.nextLine();
                    break;

                default:
                    System.out.println("Invalid choice");
                    return;
            }
                String departmentInsertSQL = "INSERT INTO department (name) VALUES ('" + name + "')";
                String S_addressInsertSQL = "INSERT INTO student_address (student_id, address_line_1, address_line_2, town_city, county) VALUES ('" + studentId + "', '" + line1 + "','" + line2 + "', '" + town_city + "','" + county + "')";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {

                // Execute the insert query

                int rowsAffected = statement.executeUpdate(departmentInsertSQL);
                int rowsAffected = statement.executeUpdate(S_addressInsertSQL);

                if (rowsAffected > 0) {
                    System.out.println("Record inserted successfully.");
                } else {
                    System.out.println("Failed to insert record.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}