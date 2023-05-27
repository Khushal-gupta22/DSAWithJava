package com.company;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        // Q: Print numbers from 1 to 5
        /*
           syntax of for loops :
           
           for (initialisation ; condition ; increment/decrement) {
            //body
            }
         */
//        for (int num =1 ; num <=5; num+=1){
//            System.out.println(num);
       // }
        
        // Print numbers from 1 to n 
        Scanner in = new Scanner(System.in);
 //       int n =in.nextInt();

//        for (int num = 0; num <=5 ; num++) {
////          System.out.println(num + " " )
//            System.out.println("Hello World");
//        }

        // while loops
        /*
            Syntax :
            while (condition) {
                // body
                }
         */
//        int num = 1;
//        while (num <=5) {
//            System.out.println(num);
//            num +=1;
//        } // when we don't know how many times a loop will run , use while loop
//        // when the number of times the loop is to run is known use for loop

        /*  do while loop :

            do {
            //body

           } while (condition);
           difference bw do while and while loop : do-while loop will run atleast one time ,
            then it will check the condition.

         */
        int n= 1;
        do {
            System.out.println("Hello World");
        } while (n !=1);

    }
}
