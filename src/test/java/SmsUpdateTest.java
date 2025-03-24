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
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateCourse(courseName,credits,level,semester,durationWeeks,maxStudents, departmentID,staffID, courseID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }

    @Test
    void testUpdateGradesSuccess() throws SQLException {
        int gradeID = 1;
        int studentID = 1;
        int courseID = 1;
        int level = 8;
        int grade = 80;
        StudentManagementUpdate.updateGrades(level, grade, studentID, courseID, gradeID);
    }
    @Test
    void testUpdateGradesFailure() {
        int gradeID = 0;
        int studentID = 0;
        int courseID = 0;
        int level = 0;
        int grade = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateGrades(level, grade, studentID,courseID,gradeID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());
    }

    @Test
    void testUpdatePaymentSuccess() throws SQLException {
        int paymentID = 1;
        int studentID = 1;
        int courseID = 1;
        String paymentStatus = "TestSuccess";
        int paymentAmount = 80;
        StudentManagementUpdate.updatePayment(paymentStatus, paymentAmount, studentID,courseID,paymentID);
    }
    @Test
    void testUpdatePaymentFailure(){
        int paymentID = 0;
        int studentID = 0;
        int courseID = 0;
        String paymentStatus = "TestFailure";
        int paymentAmount = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updatePayment(paymentStatus, paymentAmount, studentID,courseID,paymentID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());

    }

    @Test
    void testUpdateCollegeSuccess() throws SQLException {
        int departmentID = 1;
        int collegeAddressID = 1;
        String addressLine1 = "TEST";
        String addressLine2 = "TEST";
        String townCity = "TEST";
        String county = "TEST";
        StudentManagementUpdate.updateCollege(addressLine1, addressLine2, townCity, county, departmentID, collegeAddressID);
    }
    @Test
    void testUpdateCollegeFailure(){
        int departmentID = 0;
        int collegeAddressID = 0;
       String addressLine1 = "TEST";
        String addressLine2 = "TEST";
        String townCity = "TEST";
        String county = "TEST";
        SQLException e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateCollege(addressLine1, addressLine2, townCity, county, departmentID, collegeAddressID));
        assertEquals("ID INVALID: must be > 0 AND must be assigned already", e.getMessage());

    }

    @Test
    void testUpdateAddressSuccess() throws SQLException{
        int studentAddressID = 1;
        int studentID = 1;
        String addressLine1 = "TEST";
        String addressLine2 = "TEST";
        String townCity = "TEST";
        String county = "TEST";
        StudentManagementUpdate.updateCollege(addressLine1, addressLine2, townCity, county,studentID,studentAddressID);
    }
    @Test
    void testUpdateAddressFailure(){
        int studentAddressID = 0;
        int studentID = 0;
        String addressLine1 = "TEST";
        String addressLine2 = "TEST";
        String townCity = "TEST";
        String county = "TEST";
        Exception e = assertThrows(SQLException.class, ()-> {
           StudentManagementUpdate.updateAddress(addressLine1, addressLine2, townCity, county, studentID, studentAddressID);
        });
    }
}