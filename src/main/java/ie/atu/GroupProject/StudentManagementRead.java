package ie.atu.GroupProject;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class StudentManagementRead {
    public static void main(String[] args) throws SQLException {
        Properties dbProps = new Properties();
        try (InputStream input = TestConnection.class.getResourceAsStream("/db.properties")) {
            if (input == null) {
                System.out.println("Unable to find db.properties");
                return;
            }
            dbProps.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String url = dbProps.getProperty("db.url");
        String username = dbProps.getProperty("db.username");
        String password = dbProps.getProperty("db.password");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the table you want to read from: \n");
            System.out.print("1. Department: \n");
            System.out.print("2. Student: \n");
            System.out.print("3. Staff: \n");
            System.out.print("4. Course: \n");
            System.out.print("5. Grades: \n");
            System.out.print("6. Payment: \n");
            System.out.print("7. CollegeAddress: \n");
            System.out.print("8. StudentAddress: \n");
            System.out.print("9. Exit: \n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            String selectSQL = "";


            switch (choice) {
                case 1:
                    ReadDepartment(url, username, password);
                    break;
                case 2:
                    ReadStudent(selectSQL,url,username);
                     break;
                case 3:
                    ReadStaff(url,username,password);
                    break;
                case 4:
                    ReadCourse(url,username,password);
                    break;
                case 5:
                    ReadGrades(url,username,password);
                    break;
                case 6:
                    ReadPayments(url,username,password);
                    break;
                case 7:
                    ReadColAddress(url,username,password);
                    break;
                case 8:
                    ReadStudAddress(url,username,password);
                    break;
                case 9:
                    System.out.print("Goodbye:)\n");
                    return;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            }



        }



    }
    public static void  ReadDepartment(String url,String username,String password) throws SQLException{
        String selectSQL = "Select * from department ";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int department = resultSet.getInt("department_id");
                String name = resultSet.getString("name");

                System.out.printf("Department ID " + department + ", Department Name " + name + "\n");

            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void ReadStudent(String url,String username, String password)throws SQLException{
        String selectSQL = "Select * from student";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int student = resultSet.getInt("student_id");
                int department = resultSet.getInt("department_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");


                System.out.printf("Student ID: " + student + " Department ID: " + department + " First Name: "  + first_name + " Last Name: " +last_name + " Email " + email +"\n" );

            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void ReadStaff(String url,String username,String password) throws SQLException{
        String selectSQL = "Select * from staff";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int staff = resultSet.getInt("staff_id");
                int department = resultSet.getInt("department_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String office = resultSet.getString("office_location");
                int phone = resultSet.getInt("phone_number");


                System.out.printf("Staff ID" + staff + "First Name" + first_name + "Last Name" + last_name + "Email" + email + "Phone Number" + phone + "Office Location" + office + "Department ID" + department + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ReadCourse(String url,String username,String password) throws SQLException{
        String selectSQL = "Select * from course";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int staff = resultSet.getInt("staff_id");
                int department = resultSet.getInt("department_id");
                int course = resultSet.getInt("course_id");
                String course_name = resultSet.getString("course_name");
                String credits = resultSet.getString("credits");
                String level = resultSet.getString("level");
                String semester = resultSet.getString("semester");
                int duration = resultSet.getInt("duration_weeks");
                int max_students = resultSet.getInt("max_students");


                System.out.printf("Course ID" + course + "Course Name" + course_name + "Credits" + credits + "Level" + level + "Semester" + semester + "Duration (Weeks)" + duration + "Department ID" + department + "Staff ID " + staff + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ReadGrades(String url,String username,String password) throws SQLException{
        String selectSQL = "Select * from grades";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int course = resultSet.getInt("course_id");
                int grade = resultSet.getInt("grade");
                int gradeId = resultSet.getInt("grade_id");
                int level = resultSet.getInt("level");
                int student = resultSet.getInt("student_id");


                System.out.printf("Grade ID " + gradeId + "Student ID " + student + "Course ID " + course + "Level " + level + "Grade " + grade + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ReadPayments(String url,String username,String password) throws SQLException{
       String selectSQL = "Select * from payments";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int payment = resultSet.getInt("payment_id");
                int course = resultSet.getInt("course_id");
                int paymentAmount = resultSet.getInt("payment_amount");
                String paymentStatus = resultSet.getString("payment_status");
                int student = resultSet.getInt("student_id");


                System.out.printf("Payment ID " + payment + "Student ID " + student + "Course ID " + course + "Payment Status  " + paymentStatus + "Payment Amount  " + paymentAmount + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ReadStudAddress(String url,String username,String password) throws SQLException{
        String selectSQL = "Select * from student_address";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int studAddressId = resultSet.getInt("student_address_id");
                int student = resultSet.getInt("student_id");
                String address1 = resultSet.getString("address_line_1");
                String address2 = resultSet.getString("address_line_2");
                String town_city = resultSet.getString("town_city");
                String county = resultSet.getString("county");



                System.out.printf("Student Address ID " + studAddressId + "Student ID " + student + "Address Line 1 " + address1 + "Address Line 2 " + address2 + "Town_City " + town_city + "County" + county + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ReadColAddress(String url,String username,String password)throws SQLException{
        String selectSQL = "Select * from college_address";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            while(resultSet.next()){
                int collegeAddressId = resultSet.getInt("college_address_id");
                int department = resultSet.getInt("department_id");
                String address1 = resultSet.getString("address_line_1");
                String address2 = resultSet.getString("address_line_2");
                String town_city = resultSet.getString("town_city");
                String county = resultSet.getString("county");



                System.out.printf("College Address ID " + collegeAddressId + "Department ID " + department + "Address Line 1 " + address1 + "Address Line 2 " + address2 + "Town_City " + town_city + "County" + county + "\n");
            }
        }
        catch (SQLSyntaxErrorException e) {
            throw new SQLSyntaxErrorException("Error: SQL connection not found.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
