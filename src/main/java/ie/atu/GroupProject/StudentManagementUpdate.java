package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StudentManagementUpdate {
    public static void main(String[] args) {

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
                    System.out.println("Update Department\nPlease enter ID: ");
                    int departmentID = sc.nextInt();

                    //TODO: add error msg when we add ID that doesnt exist yet
                    // add same functionality for all switch cases
                    // test for failure, add exceptions and error logs
                    //Connects using db.properties,
                    //Uses prepare stmt to write query to update dept name at corresponding ID,
                    try (Connection con = DriverManager.getConnection(url, username, password)) {
                        PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
                        System.out.println("Enter new name: ");
                        String name = sc.next();
                        stmt.setString(1, name);
                        int rowsUpdated = stmt.executeUpdate();
                        System.out.println("Rows Updated Successfully: " + rowsUpdated);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Could not Connect");
                    }
                    break;
                case 2:
                    System.out.println("Update Student");
                    break;
                case 3:
                    System.out.println("Update Staff");
                    break;
                case 4:
                    System.out.println("Update Course");
                    break;
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
}
