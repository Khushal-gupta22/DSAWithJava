package com.company;

import java.util.Scanner;

public class ClimbStairsWithJumps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = 1; j <= arr[i] && i+j < dp.length; j++) {
                dp[i] += dp[i+j];
            }
        }

        System.out.println(dp[0]);

        // recursive solution below -

        int result = countPaths(0, arr, dp);
        System.out.println(result);
    }

    public static int countPaths(int index, int[] arr, int[] dp) {
        if (index == dp.length - 1) {
            return 1;
        }

        if (dp[index] !=0) {
            return dp[index];
        }


        for (int i = 1; i <= arr[index] && i+index < dp.length; i++) {
            dp[index] += countPaths(index + i, arr, dp);
        }

        return dp[index];
    }
}

//    public static int countPaths(int n, int[] qb) {
//
//    }

