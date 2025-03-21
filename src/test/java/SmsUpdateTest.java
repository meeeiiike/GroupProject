import ie.atu.GroupProject.DbUtils;
import java.sql.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmsUpdateTest {
    @Test
    void testUpdateDepartmentSuccess(){
        int departmentID = 1;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            String name = "TestAtuSuccess";
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateDepartmentFailure(){
        int departmentID = 0;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE department SET name = ? WHERE department_id = " + departmentID);
            String name = "TestAtuSuccess";
            stmt.setString(1, name);
            int rowsUpdated = stmt.executeUpdate();
            // not the best way of doing it, certainly not as good as pauls the way he creates
            // an instance of Calc (our case student management system) then calls the add
            // function or whatever ( crud operations for us ) inside a lambda
            // if we refactor our code to reduce redundancy we could definitely go
            // about it this way, but for now ill focus on functionality
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateStudentSuccess(){
        int studentID = 1;
        int departmentID = 1;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student SET first_name = ?, last_name =?, email = ?, department_id = ? WHERE student_id = " + studentID);
            String firstName = "TestFirstName";
            String lastName = "TestLastName";
            String email = "TestEmail";

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setInt(4, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateStudentFailure(){
        int studentID = 0;
        int departmentID = 0;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE student SET first_name = ?, last_name =?, email = ?, department_id = ? WHERE student_id = " + studentID);
            String firstName = "TestFirstName";
            String lastName = "TestLastName";
            String email = "TestEmail";

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setInt(4, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            // not the best way of doing it, certainly not as good as pauls the way he creates
            // an instance of Calc (our case student management system) then calls the add
            // function or whatever ( crud operations for us ) inside a lambda
            // if we refactor our code to reduce redundancy we could definitely go
            // about it this way, but for now ill focus on functionality
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateStaffSuccess(){
        int staffID = 1;
        int departmentID = 1;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE staff SET first_name = ?, last_name =?, email = ?, phone_number =?, office_location = ?, department_id =? WHERE staff_id = " + staffID);
            String firstName = "TestFirstName";
            String lastName = "TestLastName";
            String email = "TestEmail";
            String phoneNumber = "Test087000000";
            String officeLocation = "TestOfficeLocation";

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, officeLocation);
            stmt.setInt(6, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateStaffFailure(){
        int staffID = 0;
        int departmentID = 0;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE staff SET first_name = ?, last_name =?, email = ?, phone_number =?, office_location = ?, department_id =?  WHERE staff_id = " + staffID);
            String firstName = "TestFirstName";
            String lastName = "TestLastName";
            String email = "TestEmail";
            String phoneNumber = "Test087000000";
            String officeLocation = "TestOfficeLocation";

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, officeLocation);
            stmt.setInt(6, departmentID);

            int rowsUpdated = stmt.executeUpdate();
            // not the best way of doing it, certainly not as good as pauls the way he creates
            // an instance of Calc (our case student management system) then calls the add
            // function or whatever ( crud operations for us ) inside a lambda
            // if we refactor our code to reduce redundancy we could definitely go
            // about it this way, but for now ill focus on functionality
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateCourseSuccess(){
        int courseID = 1;
        int departmentID = 1;
        int staffID = 1;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE course SET course_name = ?, credits =?, level = ?, semester =?, duration_weeks = ?, max_students = ?, department_id =?, staff_id = ? WHERE course_id = " + courseID);
            String courseName = "TestFirstName";
            int credits = 10;
            int level = 8;
            int semester = 2;
            int durationWeeks = 20;
            int maxStudents = 40;

            stmt.setString(1, courseName);
            stmt.setInt(2, credits);
            stmt.setInt(3, level);
            stmt.setInt(4, semester);
            stmt.setInt(5, durationWeeks);
            stmt.setInt(6, maxStudents);
            stmt.setInt(7, departmentID);
            stmt.setInt(8, staffID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(1, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect" + e.getMessage());
        }
    }
    @Test
    void testUpdateCourseFailure(){
        int courseID = 0;
        int departmentID = 0;
        int staffID =0;

        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE course SET course_name = ?, credits =?, level = ?, semester =?, duration_weeks = ?, max_students = ?, department_id =?, staff_id = ?  WHERE course_id = " + courseID);
            String courseName = "TestSoftware";
            int credits = 10;
            int level = 8;
            int semester = 2;
            int durationWeeks = 20;
            int maxStudents = 40;

            stmt.setString(1, courseName);
            stmt.setInt(2, credits);
            stmt.setInt(3, level);
            stmt.setInt(4, semester);
            stmt.setInt(5, durationWeeks);
            stmt.setInt(6, maxStudents);
            stmt.setInt(7, departmentID);
            stmt.setInt(8, staffID);

            int rowsUpdated = stmt.executeUpdate();
            assertEquals(0, rowsUpdated);
            System.out.println("Rows Updated Successfully: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not Connect " + e.getMessage());
        }
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
