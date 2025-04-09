
import java.sql.*;
import ie.atu.GroupProject.StudentManagementCreate;
import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


// first thing just make sure you change name of class to SmsCreateTest,
public class SmsCreateTest {
// Test Create Department
    @Test
    void testInsertDepartmentSuccess() throws SQLException {
            String name = "TestDepartmentSuccess";
            StudentManagementCreate.setDepartmentInput(name);
            }

    @Test
    void testInsertDepartmentFailure() {
            String name = "TestDepartmentFailure-61234567890-12345678901234567890234567890234567890";
            Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setDepartmentInput(name));
            assertEquals("Data truncation: Data too long for column 'name' at row 1", e.getMessage());
            }

// Test Create Student
    @Test
    void testInsertStudentSuccess() throws SQLException {
        int department_id = 25;
            String first_Name = "TestFirstName";
            String last_Name = "TestLastName";
            String email = "TestEmail";
            StudentManagementCreate.setStudentInput(department_id, first_Name, last_Name, email);
            }

    @Test
    void testInsertStudentFailure() {
        int department_id = 0;
            String first_name = "TestFirstName";
            String last_name = "TestLastName";
            String email = "TestEmail";
            Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setStudentInput(department_id, first_name, last_name, email));
            assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`student`, CONSTRAINT `student_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))", e.getMessage());
            }

    // Test Create Staff
    @Test
    void testInsertStaffSuccess() throws SQLException {
        String first_name = "TestFirstName";
        String last_name = "TestLastName";
        String email = "TestEmail";
        String phone_number = "TestPhoneNumber";
        String office_location = "TestOfficeLocation";
    int department_id = 44;
        StudentManagementCreate.setStaffInput(first_name, last_name, email, phone_number, office_location, department_id);

        }

    @Test
    void testInsertStaffFailure() {
        String first_name = "TestFirstName";
        String last_name = "TestLastName";
        String email = "TestEmail";
        String phone_number = "TestPhoneNumber";
        String office_location = "TestOfficeLocation";
    int department_id = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setStaffInput(first_name, last_name, email, phone_number, office_location, department_id));
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`staff`, CONSTRAINT `staff_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))" , e.getMessage());

        }


    // Test Create Staff
    @Test
    void testInsertCourseSuccess() throws SQLException {
        String first_name = "TestFirstName";
        String last_name = "TestLastName";
        String email = "TestEmail";
        String phone_number = "TestPhoneNumber";
        String office_location = "TestOfficeLocation";
        int department_id = 44;
        StudentManagementCreate.setStaffInput(first_name, last_name, email, phone_number, office_location, department_id);
        }

    @Test
    void testInsertCourseFailure() {

        String first_name = "TestFirstName";
        String last_name = "TestLastName";
        String email = "TestEmail";
        String phone_number = "TestPhoneNumber";
        String office_location = "TestOfficeLocation";
    int department_id = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setStaffInput(first_name, last_name, email, phone_number, office_location, department_id));
        //        String courseInsertSQL = "INSERT INTO course (course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id) VALUES ('" + course_name + "','" + credits + "', '" + level + "','" + semester + "','" + duration_weeks + "', '" + max_students + "', '" + department_id + "','" + staff_id + "')";
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`staff`, CONSTRAINT `staff_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))" , e.getMessage());
        }
}





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