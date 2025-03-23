import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import ie.atu.GroupProject.DbUtils;
import java.sql.*;

import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmsUpdateTest {
    @Test
    void testUpdateDepartmentSuccess() throws SQLException {
        int departmentID = 1;
        String name = "TestAtuSuccess";
        StudentManagementUpdate.updateDepartment(name,departmentID);
    }
    @Test
    void testUpdateDepartmentFailure(){
        int departmentID = 0;
        String name = "TestAtuFailure";
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateDepartment(name, departmentID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }
    @Test
    void testUpdateStudentSuccess() throws SQLException {
        int studentID = 1;
        int departmentID = 1;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String email = "TestEmail";
        StudentManagementUpdate.updateStudent(firstName, lastName, email, departmentID, studentID);
    }
    @Test
    void testUpdateStudentFailure(){
        int studentID = 0;
        int departmentID = 0;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String email = "TestEmail";
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateStudent(firstName, lastName, email, departmentID, studentID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }
    @Test
    void testUpdateStaffSuccess() throws SQLException {
        int staffID = 1;
        int departmentID = 1;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String email = "TestEmail";
        String phoneNumber = "Test087000000";
        String officeLocation = "TestOfficeLocation";
        StudentManagementUpdate.updateStaff(firstName, lastName, email, phoneNumber, officeLocation, departmentID, staffID);
    }
    @Test
    void testUpdateStaffFailure(){
        int staffID = 0;
        int departmentID = 0;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String email = "TestEmail";
        String phoneNumber = "Test087000000";
        String officeLocation = "TestOfficeLocation";
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateStaff(firstName, lastName, email, phoneNumber, officeLocation, departmentID, staffID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }
    @Test
    void testUpdateCourseSuccess() throws SQLException {
        int courseID = 1;
        int departmentID = 1;
        int staffID = 1;
        String courseName = "TestSuccess";
        int credits = 10;
        int level = 8;
        int semester = 2;
        int durationWeeks = 20;
        int maxStudents = 40;
        StudentManagementUpdate.updateCourse(courseName,credits,level,semester,durationWeeks,maxStudents, departmentID,staffID, courseID);
    }
    @Test
    void testUpdateCourseFailure(){
        int courseID = 0;
        int departmentID = 0;
        int staffID =0;
        String courseName = "TestFailure";
        int credits = 10;
        int level = 8;
        int semester = 2;
        int durationWeeks = 20;
        int maxStudents = 40;

        Exception e = assertThrows(SQLException.class, ()-> {
            StudentManagementUpdate.updateCourse(courseName,credits,level,semester,durationWeeks,maxStudents, departmentID,staffID, courseID);
        });
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }
    @Test
    void testUpdateGradesSuccess(){
        int gradeID = 1;
        int studentID = 1;
        int courseID = 1;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE grades SET level = ?, grade =?, student_id =?, course_id = ? WHERE grade_id = " + gradeID);
            int level = 8;
            int grade = 80;

            stmt.setInt(1, level);
            stmt.setInt(2, grade);
            stmt.setInt(3, studentID);
            stmt.setInt(4, courseID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateGradesFailure() {
        int gradeID = 0;
        int studentID = 0;
        int courseID = 0;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE grades SET level = ?, grade =?, student_id =?, course_id = ? WHERE grade_id = " + gradeID);
            int level = 8;
            int grade = 80;

            stmt.setInt(1, level);
            stmt.setInt(2, grade);
            stmt.setInt(3, studentID);
            stmt.setInt(4, courseID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdatePaymentSuccess(){
        int paymentID = 1;
        int studentID = 1;
        int courseID = 1;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE payments SET payment_status = ?, payment_amount =?, student_id =?, course_id = ? WHERE payment_id = " + paymentID);
            String paymentStatus = "TEST";
            int paymentAmount = 80;

            stmt.setString(1, paymentStatus);
            stmt.setInt(2, paymentAmount);
            stmt.setInt(3, studentID);
            stmt.setInt(4, courseID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdatePaymentFailure(){
        int paymentID = 0;
        int studentID = 0;
        int courseID = 0;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE payments SET payment_status = ?, payment_amount =?, student_id =?, course_id = ? WHERE payment_id = " + paymentID);
            String paymentStatus = "TEST";
            int paymentAmount = 80;

            stmt.setString(1, paymentStatus);
            stmt.setInt(2, paymentAmount);
            stmt.setInt(3, studentID);
            stmt.setInt(4, courseID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateCollegeSuccess(){
        int departmentID = 1;
        int collegeAddressID = 1;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE college_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, department_id = ? WHERE college_address_id = " + collegeAddressID);
            String addressLine1 = "TEST";
            String addressLine2 = "TEST";
            String townCity = "TEST";
            String county = "TEST";

            stmt.setString(1, addressLine1);
            stmt.setString(2, addressLine2);
            stmt.setString(3, townCity);
            stmt.setString(4, county);
            stmt.setInt(5, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
}
    @Test
    void testUpdateCollegeFailure(){
        int departmentID = 0;
        int collegeAddressID = 0;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE college_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, department_id = ? WHERE college_address_id = " + collegeAddressID);
            String addressLine1 = "TEST";
            String addressLine2 = "TEST";
            String townCity = "TEST";
            String county = "TEST";

            stmt.setString(1, addressLine1);
            stmt.setString(2, addressLine2);
            stmt.setString(3, townCity);
            stmt.setString(4, county);
            stmt.setInt(5, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateAddressSuccess(){
        int studentAddressID = 1;
        int studentID = 1;


        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, student_id = ? WHERE student_address_id = " + studentAddressID);
            String addressLine1 = "TEST";
            String addressLine2 = "TEST";
            String townCity = "TEST";
            String county = "TEST";

            stmt.setString(1, addressLine1);
            stmt.setString(2, addressLine2);
            stmt.setString(3, townCity);
            stmt.setString(4, county);
            stmt.setInt(5, studentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateAddressFailure(){
        int studentAddressID = 0;
        int studentID = 0;


        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student_address SET address_line_1 = ?, address_line_2 =?, town_city =?, county = ?, student_id = ? WHERE student_address_id = " + studentAddressID);
            String addressLine1 = "TEST";
            String addressLine2 = "TEST";
            String townCity = "TEST";
            String county = "TEST";

            stmt.setString(1, addressLine1);
            stmt.setString(2, addressLine2);
            stmt.setString(3, townCity);
            stmt.setString(4, county);
            stmt.setInt(5, studentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }

}
