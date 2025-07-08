package org.example;

import java.util.Scanner;

public class EvenOdd {

    public static void main(String[] args) {

        System.out.print("Enter the Value  : ");

        Scanner input = new Scanner(System.in) ;

        int value = input.nextInt() ;

        if(value % 2 == 0 ) {
            System.out.println("Even Value") ;
        }
        else{
            System.out.println("Odd value");
        }

        input.close();

    }

}
