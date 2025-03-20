import ie.atu.GroupProject.StudentManagementUpdate;
import ie.atu.GroupProject.TestConnection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmsUpdateTest {

    static String url;
    static String username;
    static String password;

    @BeforeAll
    static void setup(){
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
        url = dbProps.getProperty("db.url");
        username = dbProps.getProperty("db.username");
        password = dbProps.getProperty("db.password");
        // |------------------------------------------------------------------------------------------------------------------------|
    }
    //TODO: Call the method to reduce redundancy for all cases
    @Test
    void testUpdateDepartmentSuccess(){
        int departmentID = 1;
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            String name = "TestAtuSuccess";
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateDepartmentFailure(){
        int departmentID = 0;
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            String name = "TestAtuSuccess";
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            // not the best way of doing it, certainly not as good as pauls the way he creates
            // an instance of Calc (our case student management system) then calls the add
            // function or whatever ( crud operations for us ) inside a lambda
            // if we refactor our code to reduce redundancy we could definitely go
            // about it this way, but for now ill focus on functionality
            assertEquals(0, rowsUpdated);
            //   System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
}
