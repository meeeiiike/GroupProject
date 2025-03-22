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
}
