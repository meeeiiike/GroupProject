package ie.atu.GroupProject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementCreate {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sms";
        String user = "root"; // Database Username
        String password = "password"; // Database Password

        Scanner studentInput = new Scanner(System.in);
        //get name of first student
        System.out.println("Please enter department name: ");
        String name = studentInput.nextLine();

        String insertSQL = "INSERT INTO department ( name) VALUES ('" + name + "')";

        try (Connection connection = DriverManager.getConnection(url, user, password);
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
