package com.company;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the nth number you want find of the fibonacci series : ");
        int n = in.nextInt();
        int a= 0;
        int b= 1;
        int count =2;
        while (count<=n){
            int temp = b;
            b= b+ a;
            a= temp;
            count++;
        }
        System.out.println("the "+ n + "th number of the fibonacci series is : " +b);
    }
}
