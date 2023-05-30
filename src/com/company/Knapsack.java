package com.company;

import java.util.Scanner;

public class Knapsack {
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

        int[][] dp = new int[n+1][target+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if ( j >= wts[i-1] ) {
                    int rCap = j - wts[i-1];
                    //when i doesn't bat
                    dp[i][j] = Math.max(dp[i - 1][rCap] + vals[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][target]);
    }
}
