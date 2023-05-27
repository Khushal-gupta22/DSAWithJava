package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();

//     //classic switch syntax                    //not adding break will make the all the statements execute below it
//        switch (fruit) {
//            case "mango":
//                System.out.println("King of fruits");
//                break;
//            case "Apple":
//                System.out.println("A sweet red fruit");
//                break;
//            case "Orange":
//                System.out.println("Round fruit");
//                break;
//            case "grapes":
//                System.out.println("Small fruit");
//                break;
//                                                   //by convention the default statement is made at last
//            default:
//                System.out.println("please enter a valid fruit.");
//                break;
//        }

        // new enhanced switch syntax

        switch (fruit) {   //It's much more cleaner
            case "mango" -> System.out.println("King of fruits");
            case "Apple" -> System.out.println("A sweet red fruit");
            case "Orange" -> System.out.println("Round fruit");
            case "grapes" -> System.out.println("Small fruit");

            //by convention the default statement is made at last
            default -> System.out.println("please enter a valid fruit.");
        }
    }
}
