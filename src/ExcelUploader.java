
import java.util.Scanner;
import java.io. * ;
import java.sql. * ;
import  java.util. * ;
import org.apache.poi.ss.usermodel.* ;
import org.apache.poi.xssf.usermodel.* ;

public class ExcelUploader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("What do you want to upload ? ");

        System.out.println("1 → Students Data");
        System.out.println("2 → Results Data");
        int choice = sc.nextInt();

        do {
            if (choice == 1) {
               UploadStudentFromExcel.main(null);
            } else if (choice == 2) {
                UploadResult.main(null) ;
            } else {
                System.out.println("choice the right number");
                break;
            }
        }
        while (choice < 3 || choice > 0);


    }


}