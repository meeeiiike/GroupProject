
import ie.atu.GroupProject.StudentManagementDelete;
import ie.atu.GroupProject.StudentManagementRead;
import org.junit.jupiter.api.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;


public class SmsReadTest {

   @Test
    void testDepartmentReadSuccess()throws SQLException{
       String url = "jdbc:mysql://localhost:3306/sms";
       String username = "root";
       String password = "password";

       StudentManagementRead.ReadDepartment(url, username, password);
   }

    @Test
    void testDepartmentReadFailure()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadDepartment(url, username, password));
        assertEquals("Error: SQL connection not found.", ex.getMessage());

    }

}