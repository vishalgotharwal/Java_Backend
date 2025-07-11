import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDate {

    public static void main(String[] args) {

        Connection con = StudentManagement.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the department");
        String department = sc.nextLine();

        System.out.println("Enter the Roll_no");
        int roll_no = sc.nextInt();

        String update = "UPDATE students  SET ?  WHERE roll_no = ? AND department = ? ";
        String sql = "select * from students where roll_no = ?  and department = ?";

        try (
                PreparedStatement pst = con.prepareStatement(sql)
        ) {
            pst.setInt(1, roll_no);
            pst.setString(2, department);

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


                System.out.println("🔹 Roll No: " + rollNo);
                System.out.println("🔹 Name   : " + firstName + " " + lastName);
                System.out.println("🔹 Dept   : " + dept);
                System.out.println("🔹 Mobile : " + mobile);
                System.out.println("🔹 Email  : " + email);
                System.out.println("----------------------------------");

                update(con , sc , roll_no , department ) ;

            }

        } catch (SQLException e) {
            System.out.println("Error in Update" + e.getMessage());
        }

    }


 public static void  update(Connection con , Scanner sc , int roll_no , String department){

     System.out.println("which data do you want to update");
     sc.nextLine() ;
      String value =  sc.nextLine() ;

     System.out.println(value + " so enter it : what you  want to store here :");
       int rollNumber = sc.nextInt() ;

      String update_query = "update students set roll_no = ?  where roll_no = ? and department = ? " ;


      try(PreparedStatement prt = con.prepareStatement(update_query)  )
      {

prt.setInt(1 , rollNumber);
prt.setInt(2 , roll_no);
prt.setString(3 , department);

int rowsAffected = prt.executeUpdate() ;

if(rowsAffected > 0 ){
    System.out.println("roll number updated successfully");
}
else{
    System.out.println("Failed to Update");
}



          //






      }
      catch(SQLException e ){
          System.out.println("Error in the update data :"  + e.getMessage());
      }



        }





    }



