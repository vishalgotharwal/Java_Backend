package org.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        String again ;
        double output = 0;
        Scanner sc = new Scanner(System.in) ;

        System.out.println("Enter the Value of First Number : ");
        double a = sc.nextDouble() ;
        System.out.println("Enter the Value of Second Number : ");
        double b = sc.nextDouble() ;


        System.out.println("Enter the expression (+/-/*/)");
        sc.nextLine() ;
        String expression = sc.nextLine() ;




        do {
            
           if(output != 0 ) {
                a= output ;
               System.out.println("again enter value");
                b = sc.nextInt() ;
                sc.nextLine() ;
           }


            switch (expression) {

                case "+":
                    output = a+b ;
                 System.out.println(output);
                    break;
                case "-":
                    output = a-b ;
                 System.out.println(output);
                    break;
                case "*":
                    output = a * b ;
                    System.out.println(output);
                    break;
                case "/":
                    output = a / b ;
                    System.out.println(output);
                    break ;

                default:
                    System.out.println("Please Enter the Correct Value");


            }

            System.out.println("want to add again with output (Y/N)");
            again = sc.nextLine() ;
            if(again.equals("N"))return;
            System.out.println("Enter the expression (+/-/*/)");
            expression = sc.nextLine() ;

        }
        while(again.equals("Y")) ;


    }


}
