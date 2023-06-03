package com.company;

import java.util.Scanner;

public class houseColoring2 {
    // many colors
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[n][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][c];
        System.arraycopy(arr[1], 0, dp[1], 0, dp[0].length);

        // approach 1 - O(n^3) time complexity
        for (int i = 1; i < dp.length ; i++) {
            for( int j = 1; j <dp[0].length; j++) {

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if ( k !=  j) {
                        if ( dp[i-1][k] < min) {
                            min = dp[i-1][k];
                        }
                    }
                }

                dp[i][j] = arr[i][j] + min;
            }

        }

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < dp[0].length; k++) {
            if ( dp[n-1][k] < min) {
                min = dp[n-1][k];
            }
        }
        System.out.println(min);

        // optimized approach - find least and second least approach gives O(n^2)
        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[0][j] < least) {
                secondLeast = least;
                least = dp[0][j];
            } else if (dp[0][j] <= secondLeast) {
                secondLeast = dp[0][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast= Integer.MAX_VALUE;
            for (int j = 1; j < dp[0].length ; j++) {
                if ( least == dp[i-1][j]) {
                    dp[i][j] = arr[i][j] + secondLeast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }
                if (dp[i][j] < newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                } else if (dp[i][j] <= newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }
            least = newLeast;
            secondLeast = newSecondLeast;
            System.out.println(least);

        }
    }
}
