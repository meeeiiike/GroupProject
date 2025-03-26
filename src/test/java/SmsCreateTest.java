
import java.sql.*;
import ie.atu.GroupProject.StudentManagementCreate;
import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


// first thing just make sure you change name of class to SmsCreateTest,
public class CreateTest {

    @Test
    void testInsertDepartmentSuccess() throws SQLException {
        String name = "TestAtuSuccess";
        StudentManagementCreate.setDepartmentInput(name);
    }

    @Test
        void testInsertDepartmentFailure() {
            String name = "61234567890-12345678901234567890234567890234567890-";
            Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setDepartmentInput(name));
            assertEquals("Data truncation: Data too long for column 'name' at row 1", e.getMessage());
         }
/*
    @Test
        void testInsertStudententSuccess() throws SQLException {
        int departmentID = 1;
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String email = "TestEmail";
        StudentManagementUpdate.setStudentInput(firstName, lastName, email, departmentID);
            StudentManagementCreate.setDepartmentInput(name);
        }

    @Test
        void testInsertStudentFailure() {
            String name = "61234567890-12345678901234567890234567890234567890-";
            Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setDepartmentInput(name));
            assertEquals("Data truncation: Data too long for column 'name' at row 1", e.getMessage());
        }
    }

 */

    //@test departmentFailure- assertThrows like how it is in out failure tests
    // basically the same as success one, you pass all the dummy values but for the
    // failure one we do assert throws and do the lambda thing,
    // and THEN you call StudentManagementCreate.setDepartmentInput(name); inside of that
    //Example from mine: Exception e = assertThrows(SQLException.class, ()-> StudentManagementUpdate.updateDepartment(name, departmentID));

    //same format for rest fo tables
    // this should give you basic coverage which should be grand.

    //remember to look at any of the code from our classes to help yourself



// YOP YOP ezpz. so you need to break it first then create failure tests
      /* example failure for you
       int id = "t"; string exceed varchar 50
    @Test
    void testInsertDepartmentFailure() throws SQLException {
        String name = "TestAtuSuccess";
        Exception e = assertThrows(SQLException.class, ()-> {
            StudentManagementCreate.setDepartmentInput(name);
            Cannot add or update a child row: a foreign key constraint fails (`sms`.`student`, CONSTRAINT `student_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))
        }
    }
     boom failure finito
     */