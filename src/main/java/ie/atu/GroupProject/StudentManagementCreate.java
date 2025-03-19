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

        Scanner departmentInput = new Scanner(System.in);
        // Get name of department
        System.out.println("Please enter department name: ");
        String name = departmentInput.nextLine();

        String Dept insertSQL = "INSERT INTO department ( name) VALUES ('" + name + "')";
        //insertSQL


        Scanner studentidInput = new Scanner(System.in);
        System.out.println("Please enter student id: ");
        String sid = studentidInput.nextLine();

        Scanner studentad1Input = new Scanner(System.in);
        System.out.println("Please enter student address line 1: ");
        String line1 = studentad1Input.nextLine();

        Scanner studentad2Input = new Scanner(System.in);
        System.out.println("Please enter student address line 2: ");
        String line2 = studentad2Input.nextLine();

        Scanner studentadTcInput = new Scanner(System.in);
        System.out.println("Please enter student address town/city: ");
        String line3 = studentadTcInput.nextLine();

        Scanner studentadCInput = new Scanner(System.in);
        System.out.println("Please enter student address town/city: ");
        String line4 = studentadCInput.nextLine();


        String insertSQL = "INSERT INTO student_address (student_id, address_line_1, address_line_2, town_city, county) VALUES ('" + sid + "', '" + line1 + "','" + line2 + "', '" + line3 + "','" + line4 +"')";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute the insert query
            int rowsAffected = statement.executeUpdate(insertSQL);

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
