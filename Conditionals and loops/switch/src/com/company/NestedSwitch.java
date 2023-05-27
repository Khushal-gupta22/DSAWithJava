package com.company;

import java.util.Scanner;

public class NestedSwitch {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int empID = in.nextInt();
        String department = in.next();
//
//        switch (empID){
//            case 1:
//                System.out.println("Kunal Kushwaha");
//                break;
//            case 2 :
//                System.out.println("Rahul Rana");
//                break;
//            case 3 :
//                System.out.println("Emp Number 3");
//                switch (department) {
//                    case "IT":
//                        System.out.println("IT department");
//                        break;
//                    case "Management":
//                        System.out.println("Managing Department");
//                        break;
//                    default:
//                        System.out.println("Enter correct department ID");
//
//
//                }

        switch (empID) {
            case 1 -> System.out.println("Kunal Kushwaha");
            case 2 -> System.out.println("Rahul Rana");
            case 3 -> {
                System.out.println("Emp Number 3");
                switch (department) {
                    case "IT" -> System.out.println("IT department");
                    case "Management" -> System.out.println("Managing Department");
                    default -> System.out.println("Enter correct department ID");
                }
            }
        }
    }
}
