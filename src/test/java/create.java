import ie.atu.GroupProject.StudentManagementCreate;
import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

// first thing just make sure you change name of class to SmsCreateTest,
public class create {
    @Test
    void testInsertDepartmentSuccess() throws SQLException {
        String name = "TestAtuSuccess";
        StudentManagementCreate.setDepartmentInput(name);
    }
    //@test departmentFailure- assertThrows like how it is in out failure tests
    // basically the same as success one, you pass all the dummy values but for the
    // failure one we do assert throws and do the lambda thing,
    // and THEN you call StudentManagementCreate.setDepartmentInput(name); inside of that
    //Example from mine: Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateDepartment(name, departmentID));

    /* example failure for you
    @Test
    void testInsertDepartmentFailure() throws SQLException {
        String name = "TestAtuSuccess";
        Exception e = assertThrows(SQLException.class, ()-> {
            StudentManagementCreate.setDepartmentInput(name);
        }
    }
     boom failure finito
     */

    //same format for rest fo tables
    // this should give you basic coverage which should be grand.

    //remember to look at any of the code from our classes to help yourself
}
