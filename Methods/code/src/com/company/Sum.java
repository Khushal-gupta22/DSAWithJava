package com.company;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
//        int ans = sum2();
//        System.out.println(ans);
        int ans = sum3(20,30);
    }
    // pass the value of numbers when you are calling the method in main()
    //return the value


    static int sum3(int a , int b){
        int sum= a+ b ;
        return sum;
    }

    static int sum2() {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter number 1 : ");
        int num1 = in.nextInt();
        System.out.print("Enter number 2 : ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        return sum;
    }


    static void sum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1 : ");
        int num1 = in.nextInt();
        System.out.print("Enter umber 2 : ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum = " + sum);
    }


    }
    /*
       return_type name (arguments) {
       // body
       return statement;

       }


     */

