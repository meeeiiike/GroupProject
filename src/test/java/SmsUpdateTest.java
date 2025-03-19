import ie.atu.GroupProject.TestConnection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    void testUpdateDepartmentSuccess(){
        int departmentID = 1;
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            String name = "TestATU";
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
}
