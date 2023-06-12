package com.company;

import java.util.Scanner;

public class BuyAndSellStocks1 {
    // these are a category of problems ,
    // ques 1 - you are given n days and the prices of stocks on each dat. you have to calculate the max profit if only one transaction is allowed .
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar= prices[i];
            }

            profitIfSoldToday = prices[i] - leastSoFar;
            if (profitIfSoldToday > overallProfit) {
                overallProfit = profitIfSoldToday;
            }
        }
        System.out.println(overallProfit);
    }
}
