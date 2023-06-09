package com.company;

import java.util.Scanner;

public class BuyAndSellStocks3 {
    // you ae given n days and stock price on each day. if there is a transaction fee as well you have to tell the max profit at the end
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n= scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int transFee = scn.nextInt();
        int oldBoughtStateProfit = -prices[0];
        int oldSoldStateProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;
            if ( (oldSoldStateProfit - prices[i]) > oldBoughtStateProfit ) {
                newBoughtStateProfit = oldBoughtStateProfit - prices[i];
            } else {
                newBoughtStateProfit = oldBoughtStateProfit;
            }

            if ( (oldBoughtStateProfit + prices[i] - transFee) > oldSoldStateProfit) {
                newSoldStateProfit = (oldBoughtStateProfit + prices[i] - transFee);
            } else {
                newSoldStateProfit = oldSoldStateProfit;
            }

            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
        }
        System.out.println(oldSoldStateProfit);
    }

}
