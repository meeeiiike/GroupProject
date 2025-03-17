package ie.atu.GroupProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class StudentManagementUpdate {
    public static void main(String[] args){

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
