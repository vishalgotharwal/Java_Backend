import java.sql.*;
import java.util.Scanner;

public class StudentQuery {

    public static void main(String[] args) {
        Connection conn = StudentManagement.getConnection();
        Scanner scanner = new Scanner(System.in);




        System.out.println("Please ! Enter the Department");
        String department = scanner.nextLine();


        String sql = "SELECT * FROM students WHERE department = ? ";



        try (
                PreparedStatement pst = conn.prepareStatement(sql);
        ) {
            pst.setString(1, department);
            ResultSet rs = pst.executeQuery();
            boolean found = false;

            while (rs.next()) {
                found = true;

                int rollNo = rs.getInt("roll_no");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dept = rs.getString("department");
                String mobile = rs.getString("mobile_no");
                String email = rs.getString("email");

//
                System.out.println("🔹 Roll No: " + rollNo);
//                System.out.println("🔹 Name   : " + firstName + " " + lastName);
//                System.out.println("🔹 Dept   : " + dept);
//                System.out.println("🔹 Mobile : " + mobile);
//                System.out.println("🔹 Email  : " + email);
//                System.out.println("----------------------------------");

            }

            if (!found) {
                System.out.println("No student found in the department  " + department);
            }

        } catch (SQLException e) {
            System.out.println("SQL ERROR : " + e.getMessage());
          return ;
        }



            System.out.println("Choose the Roll No IF you want to explore data for particular student");


            System.out.println("Please Enter the Roll No");
            String roll_no = scanner.nextLine();

            String sql_for_RollNO = "select * from students where roll_no = ? and department = department ";


            try (

                    PreparedStatement pst_for_Roll_no = conn.prepareStatement(sql_for_RollNO);
            ) {
                pst_for_Roll_no.setString(1, roll_no);

                ResultSet rs_for_roll_no = pst_for_Roll_no.executeQuery();

                boolean found_for_roll_no = false;

                while (rs_for_roll_no.next()) {
                    found_for_roll_no = true;


                    int rollNo = rs_for_roll_no.getInt("roll_no");
                    String firstName = rs_for_roll_no.getString("first_name");
                    String lastName = rs_for_roll_no.getString("last_name");
                    String dept = rs_for_roll_no.getString("department");
                    String mobile = rs_for_roll_no.getString("mobile_no");
                    String email = rs_for_roll_no.getString("email");

                    System.out.println("🔹 Roll No: " + rollNo);
                    System.out.println("🔹 Name   : " + firstName + " " + lastName);
                    System.out.println("🔹 Dept   : " + dept);
                    System.out.println("🔹 Mobile : " + mobile);
                    System.out.println("🔹 Email  : " + email);
                    System.out.println("----------------------------------");

                }

                if (!found_for_roll_no) {
                    System.out.println("No student found in this Roll_no  " + roll_no);
                }

            } catch (SQLException e) {
                System.out.println("Error during roll_no" + e.getMessage());
            }

        }
        }

//        Statement st = null;
//        try {
//            st = conn.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ResultSet rs = null;
//        try {
//            rs = st.executeQuery(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            rs.next() ;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        String name = null;
//        try {
//            name = rs.getString("mobile_no");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(name);
//    }




