import java.beans.Introspector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.beans.Introspector.*;

public class Createdata {

    public static void main(String[] args) {
        Connection conn = StudentManagement.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the roll no ");
        int roll_no = Integer.parseInt(sc.nextLine());


        System.out.println("enter the first name");
        String first_name = sc.nextLine();

        System.out.println("Enter the last name");
        String last_name = sc.nextLine();

        System.out.println("Enter the department");
        String department = sc.nextLine();

        System.out.println("Enter the mobile_no");
        String mobile_no = sc.nextLine();

        System.out.println("Enter the email ");
        String email = sc.nextLine();

        String Insertsql = "insert  into students (roll_no , first_name , last_name ,department ,  mobile_no , email ) " +
                "values(? , ? , ? , ? , ?  , ?) ";


        try (
                PreparedStatement pst = conn.prepareStatement(Insertsql);
        ) {
            pst.setInt(1, roll_no);
            pst.setString(2, first_name);
            pst.setString(3, last_name);
            pst.setString(4, department);
            pst.setString(5, mobile_no);
            pst.setString(6, email);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("student addes successFully");
            } else {
                System.out.println("Failed to add student");
            }

        } catch (SQLException e) {
            System.out.println("error in create operation " + e.getMessage());
        }

    }

}
