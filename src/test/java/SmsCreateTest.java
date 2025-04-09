
import java.sql.*;
import ie.atu.GroupProject.StudentManagementCreate;
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
        int department_id = 1;
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

    // Test Create Course
    @Test
    void testInsertCourseSuccess() throws SQLException {
        String course_name = "TestCourseName";
        int credits = 1;
        int level = 1;
        int semester = 1;
        int duration_weeks = 1;
        int max_students = 1;
        int department_id = 1;
        int staff_id = 4;
        StudentManagementCreate.setCourseInput(course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id);
        }

    @Test
    void testInsertCourseFailure() {
        String course_name = "TestCourseName";
        int credits = 0;
        int level = 0;
        int semester = 0;
        int duration_weeks = 0;
        int max_students = 0;
        int staff_id = 0;
        int department_id = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setCourseInput(course_name, credits, level, semester, duration_weeks, max_students, department_id, staff_id));
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`course`, CONSTRAINT `course_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))" , e.getMessage());
        }

    // Test Create Grades
    @Test
    void testInsertGradesSuccess() throws SQLException {
        int student_id = 1;
        int course_id = 3;
        int level = 1;
        int grade = 1;
        StudentManagementCreate.setGradesInput(student_id, course_id, level, grade);
    }

    @Test
    void testInsertGradesFailure() {
        int student_id = 0;
        int course_id = 0;
        int level = 0;
        int grade = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setGradesInput(student_id, course_id, level, grade));
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`grades`, CONSTRAINT `grades_idfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`))" , e.getMessage());
    }

    // Test Create Payments
    @Test
    void testInsertPaymentsSuccess() throws SQLException {
        int student_id = 1;
        int course_id = 3;
        String payment_status = "TestPaid/Unpaid";
        int payment_amount = 1;
        StudentManagementCreate.setPaymentsInput(student_id, course_id, payment_status, payment_amount);
    }

    @Test
    void testInsertPaymentsFailure() {
        int student_id = 0;
        int course_id = 0;
        String payment_status = "TestPaid/Unpaid";
        int payment_amount = 0;
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setPaymentsInput(student_id, course_id, payment_status, payment_amount));
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`payments`, CONSTRAINT `payments_idfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`))" , e.getMessage());
    }

    // Test Create College_address
    @Test
    void testInsertCollegeAddressSuccess() throws SQLException {
        int department_id = 1;
        String address_line_1 = "Address line 1";
        String address_line_2 = "Address line 2";
        String town_city = "Town/City";
        String county = "County";
        StudentManagementCreate.setCollege_addressInput(department_id, address_line_1, address_line_2, town_city, county);
    }

    @Test
    void testInsertCollegeAddressFailure() {
        int department_id = 0;
        String address_line_1 = "Address line 1";
        String address_line_2 = "Address line 2";
        String town_city = "Town/City";
        String county = "County";
        Exception e = assertThrows(SQLException.class, ()-> StudentManagementCreate.setCollege_addressInput(department_id, address_line_1, address_line_2, town_city, county));
        assertEquals("Cannot add or update a child row: a foreign key constraint fails (`sms`.`college_address`, CONSTRAINT `college_address_idfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`))" , e.getMessage());
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