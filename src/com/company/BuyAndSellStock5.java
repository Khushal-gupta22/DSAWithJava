package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuyAndSellStock5 {
    // here in this problem you are allowed maximum two transactions and you have to find out the maximum profit in this way
    public static void main(String[] args) throws Exception {
//        Scanner scn = new Scanner(System.in);
//        int n= scn.nextInt();
//
//        int[] arr = new int[n];
//        for( int i = 0; i < arr.length; i++) {
//            arr[i] = scn.nextInt();
//        }
//
//        int buyingDate = 0 ;
//        int sellingDate = 0;
//        ArrayList<Integer> profits = new ArrayList<>();
//
//        for ( int i = 1 ; i < arr.length; i++) {
//            if ( arr[i] > arr[i-1]) {
//                sellingDate++;
//            } else {
//                profits.add((arr[buyingDate] - arr[sellingDate]));
//                buyingDate = sellingDate = i;
//            }
//        }
//
//        profits.add((arr[buyingDate] - arr[sellingDate]));
//        int secondLargest = (int) profits.get(0);
//        int largest = profits.get(0);
//        for (int i = 1; i < profits.size(); i++) {
//            if(profits.get(i) > largest) {
//                secondLargest = largest;
//                largest = profits.get(i);
//            }
//            if(profits.get(i) > secondLargest && profits.get(i) != largest) {
//                secondLargest = profits.get(i);
//            }
//        }
//        System.out.println(largest + secondLargest);

        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr = new int[n];
        for( int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int maxProfitIfSoldToday = 0;
        int leastSoFar = arr[0];
        int[] dpMaxProfitIfSoldUptoToday = new int[arr.length];
        for (int i = 1; i <arr.length; i++) {
            if ( arr[i] < leastSoFar) {
                leastSoFar = arr[i];
            }

            maxProfitIfSoldToday = arr[i] - leastSoFar;
            if ( maxProfitIfSoldToday > dpMaxProfitIfSoldUptoToday[i-1]) {
                dpMaxProfitIfSoldUptoToday[i] = maxProfitIfSoldToday;
            } else {
                dpMaxProfitIfSoldUptoToday[i] = dpMaxProfitIfSoldUptoToday[i-1];
            }
        }

        int maxProfitIfBoughtToday = 0;
        int maxAfterToday =arr[arr.length-1];
        int[] dpMaxProfitIfBoughtTodayOrAfterToday = new int[arr.length];

        for (int i = arr.length -2; i >= 0 ; i++) { if (arr[i] > maxAfterToday) {
            maxAfterToday = arr[i];
        }

        maxProfitIfBoughtToday = maxAfterToday - arr[i];
            if (maxProfitIfBoughtToday > dpMaxProfitIfBoughtTodayOrAfterToday[i+1]) {
                dpMaxProfitIfBoughtTodayOrAfterToday[i] = maxProfitIfBoughtToday;            } else {
                dpMaxProfitIfBoughtTodayOrAfterToday[i] = dpMaxProfitIfBoughtTodayOrAfterToday[i+1];
            }

        }

        int overallProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dpMaxProfitIfSoldUptoToday[i] + dpMaxProfitIfBoughtTodayOrAfterToday[i] > overallProfit) {
                overallProfit = dpMaxProfitIfSoldUptoToday[i] + dpMaxProfitIfBoughtTodayOrAfterToday[i];
            }
        }
        System.out.println(overallProfit );

    }


}