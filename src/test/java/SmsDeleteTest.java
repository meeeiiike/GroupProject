import ie.atu.GroupProject.DbUtils;
import ie.atu.GroupProject.StudentManagementDelete;
import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmsDeleteTest {

    @Test
    void testDeleteDepartmentSuccess() throws SQLException {
        int departmentID = 1; // if 1 exist it should delete and if not should say it doesnt exist

        StudentManagementDelete.deleteDepartment(departmentID);
    }

    @Test
    void testDeleteDepartmentFailure() {
        int departmentID = 4; // Make sure that the id is referred to other tables

        Exception ex = assertThrows(SQLIntegrityConstraintViolationException.class, () -> StudentManagementDelete.deleteDepartment(departmentID));
        assertEquals("Error: Cannot delete department because it is referenced in other tables.", ex.getMessage());
    }

    @Test
    void testDeleteStudentSuccess() throws SQLException {
        int studentID = 5;

        StudentManagementDelete.deleteStudent(studentID);
    }

    @Test
    void testDeleteStudentFailure() {
        int studentID = 1;

        Exception ex = assertThrows(SQLIntegrityConstraintViolationException.class, () -> StudentManagementDelete.deleteStudent(studentID));
        assertEquals("Error: Cannot delete student because it is referenced in other tables.", ex.getMessage());
    }

    @Test
    void testDeleteStaffSuccess() throws SQLException {
        int staffID = 2;

        StudentManagementDelete.deleteStaff(staffID);
    }

    @Test
    void testDeleteStaffFailure() {
        int staffID = 1;

        Exception ex = assertThrows(SQLIntegrityConstraintViolationException.class, () -> StudentManagementDelete.deleteStaff(staffID));
        assertEquals("Error: Cannot delete staff because it is referenced in other tables.", ex.getMessage());
    }

    @Test
    void testDeleteCourseSuccess() throws SQLException {
        int courseID= 2;

        StudentManagementDelete.deleteCourse(courseID);
    }

    @Test
    void testDeleteCourseFailure() {
        int courseID = 1;

        Exception ex = assertThrows(SQLIntegrityConstraintViolationException.class, () -> StudentManagementDelete.deleteCourse(courseID));
        assertEquals("Error: Cannot delete course because it is referenced in other tables.", ex.getMessage());
    }

    //For the following tests they won't cause a SQLIntegrityConstraintViolationException, we're taking a
    //data not existing in the table as failure

    @Test
    void testDeleteGradeSuccess() throws SQLException {
        int gradeID = 1; //Make sure there is a grade with the ID listed in the database

        StudentManagementDelete.deleteGrade(gradeID);
    }

    @Test
    void testDeleteGradeFailure() throws SQLException {
        int gradeID = 100;

        StudentManagementDelete.deleteGrade(gradeID);
    }

    @Test
    void testDeletePaymentSuccess() throws SQLException {
        int paymentID = 1;

        StudentManagementDelete.deletePayment(paymentID);
    }

    @Test
    void testDeletePaymentFailure() throws SQLException {
        int paymentID = 100;

        StudentManagementDelete.deletePayment(paymentID);
    }

    @Test
    void testDeleteCollegeSuccess() throws SQLException {
        int collegeID = 1;

        StudentManagementDelete.deleteCollege(collegeID);
    }

    @Test
    void testDeleteCollegeFailure() throws SQLException {
        int collegeID = 100;

        StudentManagementDelete.deleteCollege(collegeID);
    }

    @Test
    void testDeleteAddressSuccess() throws SQLException {
        int addressID = 1;

        StudentManagementDelete.deleteAddress(addressID);
    }

    @Test
    void testDeleteAddressFailure() throws SQLException {
        int addressID = 100;

        StudentManagementDelete.deleteAddress(addressID);
    }
}
