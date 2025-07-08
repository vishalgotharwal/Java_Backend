package org.example;
import java.util.Scanner ;

public class Grade {

    public static  void main(String[] args){
        Scanner sc  =  new Scanner(System.in) ;
 System.out.println("Please Enter Your Subject  Number ") ;

 System.out.print("English : ") ;
        int EnglsihMarks = sc.nextInt() ;
        System.out.print("Hindi : ") ;
        int HindiMarks = sc.nextInt() ;
        System.out.print("Social Science : ") ;
        int SSMarks = sc.nextInt() ;
        System.out.print("Science : ") ;
        int ScienceMarks = sc.nextInt() ;

        System.out.print("Math : ") ;
        int MathMarks = sc.nextInt() ;



     int grade = (  EnglsihMarks + HindiMarks + SSMarks + ScienceMarks + MathMarks )  / 5 ;

      if(grade >= 90 && grade <=100 ){
          System.out.println("A");
      }
      else if(grade >=75 && grade <90){
          System.out.println("B");
      }
      else if(grade >=60 && grade <75) {
           System.out.println("C") ;
      }
      else if(grade >=36 && grade <60){
          System.out.println("D") ;
      }
      else {
          System.out.print("Fail");
      }
    }

}
