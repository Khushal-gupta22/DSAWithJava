package com.company;

import java.util.Scanner;

public class CountNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number :");
        int num = in.nextInt();
        System.out.print("Enter the number you want the count of :");
        int n = in.nextInt();
        int temp = num;
        int count = 0 ;
        while (num>0){
            int rem = num % 10;
            if (rem == n) {
                count++;
            }
            num = num/10;

        }
        System.out.println("The number of times "+ n + " appeared in "+ temp + " is " + count);
    }
}
