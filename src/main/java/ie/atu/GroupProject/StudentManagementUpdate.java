package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StudentManagementUpdate {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("\n Welcome to Student Management System! \n You Selected Update\n " +
                "Please Select Table to Update: \n1. Department\n2. Student\n3. Staff\n4. Course\n" +
                "5. Grades\n6. Payment\n7. College\n8. Address\n9. Exit\n Please Enter: ");
        int choice = sc.nextInt();
        sc.nextLine();

        // Get database properties
        Properties dbProps = new Properties();
        try(InputStream input = TestConnection.class.getResourceAsStream("/db.properties")){
            if(input== null){
                System.out.println("Unable to find db.properties");
                return;
            }
            dbProps.load(input);
        } catch(IOException e){
            e.printStackTrace();
            return;
        }
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");

        // Update Query
        String updateSQL = "UPDATE department SET name = 'NUIG' WHERE name = 'ATU'";

//String updateSQL = "UPDATE department SET name = '?' WHERE name = '?'";
//Layout to use when we implement code to ask user for input
//Will need to use PreparedStatements!

        // Create Connection using db.properties
        try(Connection con = DriverManager.getConnection(url, username, password)){
            Statement stmt = con.createStatement();
            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.println("Rows Updated Successfully: " +rowsUpdated);
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
}
