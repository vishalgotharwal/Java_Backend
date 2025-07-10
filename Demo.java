import java.sql.*;

public class Demo{
    public static void main(String[] args) throws SQLException {

        String  sql = "select name from orders where orderId = 3" ;
        String url = "jdbc:Mysql://localhost:3306/vishaldb" ;
        String username = "root";
        String password = "1234" ;
        Connection con = DriverManager.getConnection(url , username , password) ;
        Statement st  = con.createStatement() ;
       ResultSet rs =  st.executeQuery(sql);
       rs.next() ;
         String name =  rs.getString(1) ;
        System.out.println(name);
    }
}
