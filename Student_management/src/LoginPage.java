import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class LoginPage {


    public static void main(String[] args) {
        Scanner userdetails = new Scanner(System.in) ;
        System.out.println("----------------------------------");
        System.out.println("Welcome in GIT Collage Data Portal");
        System.out.println("Please Enter the Username : ");
        String Username =  userdetails.nextLine() ;
        System.out.println("Enter the password : ");
      String Password =   userdetails.nextLine() ;

        Properties props = new Properties() ;
      try (
       FileInputStream fis = new FileInputStream("config.properties") ;
              )
      {
  props.load(fis) ;

  String authusername = props.getProperty("LOGIN_NAME") ;
  String authPass = props.getProperty("LOGIN_PASSWORD") ;

  if(authusername.equals(Username) ){
      if(authPass.equals(Password)){
          System.out.println("SuccessFully Login");
         CRUDOperation.main(null);

      }
      else{
          System.out.println("Password Incorrect");
      }
  }
  else{
      System.out.println("username is Incorrect");
  }


      }
      catch(IOException e ){
          System.out.print("Error during Login");
      }

    }


}
