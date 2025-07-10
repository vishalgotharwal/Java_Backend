import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

    public static void main(String[] args) {

        Connection con = StudentManagement.getConnection() ;
        Scanner sc = new Scanner(System.in) ;



        System.out.println("please add the roll_no");
        int rollNO =  sc.nextInt() ;
        System.out.println("Please add the department");
        sc.nextLine() ;
        String department =  sc.nextLine() ;

        String deleteQuery = "DELETE FROM students WHERE roll_no = ? AND department = ?";

        try(PreparedStatement prt =  con.prepareStatement(deleteQuery) ){

            prt.setInt(1, rollNO);
            prt.setString(2, department);
            int rowsAffected = prt.executeUpdate() ;



            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("No record found with the given roll number and department.");
            }



        }
        catch(SQLException e ){
            System.out.println("error in delete " +e.getMessage());
        }

    }

}
