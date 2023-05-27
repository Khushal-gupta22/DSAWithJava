package com.company;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();


        // q: find the largest of the three nos..
        int max = a;
        if (b > max) {
            max = b;

        }
        if (c > max) {
            max = c;

        }
        System.out.println(max);
    }   // or can use Math.max
    // int max = Math.max(a,b);
    //int Math.max(c, Math.max(a,b));
}