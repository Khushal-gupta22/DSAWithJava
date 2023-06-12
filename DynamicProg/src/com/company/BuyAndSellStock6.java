package com.company;

import java.util.Scanner;

public class BuyAndSellStock6 {
    // here k transactions ae allowed, so you have to tell the maximum profit when  transaction are allowed
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        int k = scn.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        int[][] dp = new int[k+1][n];
        for (int transaction = 1; transaction <= dp.length; transaction++) {
            for (int day = 1; day <= dp[0].length; day++) {
                int max = dp[transaction][day - 1];
                for (int pastDay = 0; pastDay < day; pastDay++) {
                    if (dp[transaction - 1][pastDay] + price[day] - price[pastDay] > max) {
                        // dp[transaction - 1][pastDay] == is profit till t-1 transaction like if 3 transactions then t-1 === 2 transactions
                        // price[day] - price[pastDay] === is profit of transaction between presentDay - pastdDay
                        max = dp[transaction - 1][pastDay] + price[day] - price[pastDay];
                    }
                }
                dp[transaction][day] = max;

            }
        }
        System.out.println(dp[k][n-1]);

        // or below is an optimized code

        for (int transaction = 1; transaction <= dp.length; transaction++) {
            int max = Integer.MIN_VALUE;
            for( int day =1 ; day <dp[0].length; day++) {

                if ( dp[transaction -1][day -1] - price[day-1] > max) {
                    max = dp[transaction -1][day -1] - price[day-1];
                }

                if ( max + price[day] > dp[transaction][day-1]) {
                    dp[transaction][day] = max + price[day];
                } else {
                    dp[transaction][day] = dp[transaction][day-1];
                }
            }
        }
        System.out.println(dp[k][n-1]);


    }
}
