package com.company;

import java.util.Scanner;

public class BuyAndSellStocks2 {
    // type 2 you are given n nof of days and stoc prices of each day, you have to tell the max profit when infinite transaction are allowed
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int buyingDate = 0;
        int sellingDate = 0;
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if ( arr[i] >= arr[i-1]) {
                sellingDate++;
            } else {
                profit += arr[sellingDate] - arr[buyingDate] ;
                buyingDate = sellingDate = i;
            }
        }
        profit += arr[sellingDate] - arr[buyingDate] ;
        System.out.println(profit);
    }
}
