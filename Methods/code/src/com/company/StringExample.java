package com.company;

import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
//      String message = greet();
//        System.out.println(message);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String naam = in.next();
        String personalised=myGreet(naam);   //argument in this need not be same as mentioned below
        System.out.println(personalised);    // name and naam pointing to the same object
    }

    static String myGreet(String name) {
        String message = "HEllo "+ name;
        return message;
    }

    static String greet() {
        String greeting = "How are you";
        return greeting;

    }
}
