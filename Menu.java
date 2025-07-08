package org.example;

import javax.script.ScriptContext;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        int count = 0 ;



        Scanner sc = new Scanner(System.in) ;

        System.out.println("Please Choose Your Order : ") ;



        String orderValue ;
        do {

            System.out.println("1" + "." +  "Pizza");
            System.out.println("2" +  "." +  "Burger");
            System.out.println("3" +  "." +  "Coffee");
            System.out.println("4" +  "." +  "Tea");
            int Number = sc.nextInt();
            sc.nextLine();

            switch (Number) {
                case 1:
                    System.out.println("Your Order is pizza ");
                    System.out.println("Prize :" + 100 + "Rs");
                    break;
                case 2:
                    System.out.print("Your Order is Burger");
                    System.out.println("Prize :" + 75 + "Rs");
                    break;
                case 3:
                    System.out.print("Your Order is Coffee");
                    System.out.println("Prize :" + 60 + "Rs");
                    break;
                case 4:
                    System.out.println("Your Order is Tea");
                    System.out.println("Prize :" + 20 + "Rs");
                    break;

                default:
                    System.out.print("Please Choose a valid OrderId");

            }
            System.out.println("Want another Order (Yes/NO) ");

orderValue = sc.nextLine() ;


        }
        while (orderValue.equals("Yes")) ;






    }

}
