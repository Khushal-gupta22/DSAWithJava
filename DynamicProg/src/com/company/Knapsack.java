package com.company;

import java.util.Scanner;

public class Knapsack {

    // type-1 - there are total 5 types in type1 problems - targetsumsubset, coin chnage permut and comb, unbounded
    // and 0/1 knapsack
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] vals = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < vals.length; i++) {
            vals[i] = scn.nextInt();
        }
        for (int i = 0; i < wts.length; i++) {
            wts[i] = scn.nextInt();
        }
        int target = scn.nextInt();

        //logic for 0-1 knapsack

        int[][] dp = new int[n+1][target+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if ( j >= wts[i-1] ) {
                    int rCap = j - wts[i-1];
                    //when i doesn't bat
                    if (dp[i-1][rCap] + vals[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][rCap] + vals[i-1];
                    }
                   // or  dp[i][j] = Math.max(dp[i - 1][rCap] + vals[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][target]);

        // logic for unbounded knapsack
        int[] dp2 = new int[target+1];
        dp2[0] = 0;
        for( int bagCap = 1; bagCap <=target; bagCap++) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < vals.length; i++) {

                if (bagCap >= wts[i] ) {
                    int remBagCap = bagCap -wts[i];
                    int remBagVal = dp2[remBagCap];
                    int totalBagVal = remBagVal + vals[i];

                    if( totalBagVal > max) {
                        max = totalBagVal;
                    }
                }
            }
            dp2[bagCap] = max;
        }
        System.out.println(dp2[target]);
    }
}
