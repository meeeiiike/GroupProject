
import ie.atu.GroupProject.StudentManagementDelete;
import ie.atu.GroupProject.StudentManagementRead;
import org.junit.jupiter.api.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;


public class SmsReadTest {

    @Test
    void testDepartmentReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadDepartment(url, username, password);
    }

    @Test
    void testDepartmentReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadDepartment(url, username, password));
        assertEquals("Error: SQL connection not found.", ex.getMessage());

    }

    @Test
    void testStudentReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadStudent(url, password, username);
    }

    @Test
    void testStudentReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadStudent(url, password, username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }

    @Test
    void testStaffReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadStaff(url, username, password);
    }

    @Test
    void testStaffReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadStaff(url, password, username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }

    @Test
    void testCourseReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadCourse(url, username, password);
    }

    @Test
    void testCourseReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadCourse(url, password, username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }

    @Test
    void testGradesReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadGrades(url, username, password);
    }

    @Test
    void testGradesReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadGrades(url, password, username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }
    @Test
    void testPaymentsReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadPayments(url, username, password);
    }

    @Test
    void testPaymentsReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex =assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadPayments(url, password, username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }

    @Test
    void testStudAddressReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadStudAddress(url,username,password);
    }

    @Test
    void testStudAddressReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadStudAddress(url,password,username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }

    @Test
    void testColAddressReadSuccess() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "password";

        StudentManagementRead.ReadColAddress(url,username,password);
    }

    @Test
    void testColAddressReadFailure() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ssms";
        String username = "root";
        String password = "password";

        Exception ex = assertThrows(SQLSyntaxErrorException.class, () -> StudentManagementRead.ReadColAddress(url,password,username));
        assertEquals("Error: SQL connection not found.", ex.getMessage());
    }






}