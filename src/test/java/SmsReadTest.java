
import org.junit.jupiter.api.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;


public class SmsReadTest {

    private Connection connection;


    private void testTable(String tableName, String idColumn) {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 1")) {

            assertNotNull(rs, "ResultSet for " + tableName + " Shouldn't be null");
            assertTrue(rs.next(), "Table " + tableName + " Must have at least one row");

            int id = rs.getInt(idColumn);
            assertTrue(id > 0, idColumn + " in " + tableName + " must be valid");

        } catch (SQLException e) {
            fail("SQL query failed for " + tableName + ": " + e.getMessage());
        }
    }

    @Test
    void testReadDepartment(){
        testTable("Department", "departmentID");
    }

    @Test
    void testReadStudent(){
        testTable("Student", "studentID");
    }

    @Test
    void testReadStaff(){
        testTable("Staff", "staffID");
    }

    @Test
    void testReadGrades(){
        testTable("Grades", "gradeID");
    }

    @Test
    void testReadCourse(){
        testTable("Course", "courseID");
    }

    @Test
    void testReadPayment(){
        testTable("Payment", "paymentID");
    }

    @Test
    void testReadCollege(){
        testTable("CollegeAddress", "collegeAddressID");
    }
    @Test
    void testReadAddress(){
        testTable("studentAddress", "studentAddressID");
    }


}
