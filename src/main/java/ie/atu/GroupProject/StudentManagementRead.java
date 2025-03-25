package ie.atu.GroupProject;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class StudentManagementRead {
    public static void main(String[] args) {
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
                    selectSQL = "Select * from department ";
                    try (Connection connection = DriverManager.getConnection(url, username, password);
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(selectSQL)){

                        while(resultSet.next()){
                            int department = resultSet.getInt("department_id");
                            String name = resultSet.getString("name");

                            System.out.printf("Department ID " + department + ", Department Name " + name + "\n");

                        }
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 2:

                     selectSQL = "Select * from student";
                    try (Connection connection = DriverManager.getConnection(url, username, password);
                         Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(selectSQL)){

                        while(resultSet.next()){
                            int student = resultSet.getInt("student_id");
                            int department = resultSet.getInt("department_id");
                            String first_name = resultSet.getString("first_name");
                            String last_name = resultSet.getString("last_name");
                            String email = resultSet.getString("email");


                            System.out.printf("Student ID " + student + "Department ID " + department + "First Name" + first_name + "Last Name" +last_name + "Email" + email +"\n" );

                        }
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                     break;
                case 3:

                    selectSQL = "Select * from staff";
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
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:

                    selectSQL = "Select * from course";
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
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 5:

                    selectSQL = "Select * from grades where grade = ";
                    break;
                case 6:

                    selectSQL = "Select * from address where addressID = ";
                    break;
                case 7:

                    selectSQL = "Select * from college where CollegeAddressID = ";
                    break;
                case 8:

                    selectSQL = "Select * from address where StudentAddressID = ";
                    break;
                case 9:
                    System.out.print("Goodbye:)\n");
                    return;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            }

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSQL)){

                while(resultSet.next()){
                    int department = resultSet.getInt("department_id");
                    String name = resultSet.getString("name");

                    System.out.printf("Department ID " + department + "Department Name " + name);

                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }




        }



    }

}
