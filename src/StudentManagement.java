import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class StudentManagement {

private static  Connection conn = null ;

public static  Connection getConnection() {
    if(conn != null){
        return conn ;
    }

    Properties props = new Properties() ;
    try(
            FileInputStream fis = new FileInputStream("config.properties") ;


    )
    {
        props.load(fis) ;

        String url = "jdbc:mysql://" + props.getProperty("DB_HOST") +
                ":" + props.getProperty("DB_PORT") + "/" +
                props.getProperty("DB_NAME") ;
        String user = props.getProperty("DB_USER");
        String password = props.getProperty("DB_PASS") ;

conn = DriverManager.getConnection(url , user , password) ;
System.out.println("Database Connection Successfully");


    }
    catch(IOException e ) {
        System.err.println("Error loading properties file: " + e.getMessage() ) ;
    }
    catch(SQLException e ) {

        System.err.println("Error connecting to db " + e.getMessage()) ;

    }
    return conn ;

}

}
