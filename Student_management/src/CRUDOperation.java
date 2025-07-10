import java.util.Scanner;

public class CRUDOperation {

    public static void main(String[] args) {

        int num ;
        System.out.println("Which operation do you want to perform?");
        System.out.println("1. Create New Student");
        System.out.println("2. Read Student Data");
        System.out.println("3. Update Student Data");
        System.out.println("4. Delete Student Data");

        Scanner sc = new Scanner(System.in) ;
       num =  sc.nextInt() ;

        switch(num){

            case  1 :
            {
              Createdata.main(null);
                break ;
            }
            case 2 :
               StudentQuery.main(null);
               break;

            case 3 :
               UpdateDate.main(null);
                break ;

            case 4 :
              DeleteData.main(null);
                break ;

            default:
                System.out.println("you have no permission to perform another operations ");

        }



    }





}
