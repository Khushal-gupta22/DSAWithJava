package com.company;

import java.util.Scanner;

public class Goldmine {
    // You are given a 2d array which represents a goldmine and the no in that2d array represents the gold that is present in that particular bock . Standing in front wall & are supposed to dig to the right wall. you can start from any row in the left wall . the allowed mobemtns are diagonal-up(1), diagonal-down(1), and right(1).
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for( int col = dp[0].length -1 ; col >= 0; col--) {
            for ( int row = dp.length-1; row >= 0; row--) {
                if ( col == dp[0].length ) {
                    dp[row][col] = arr[row][col];
                }
                else if ( row == 0) {
                    dp[row][col] = Math.max(arr[row][col+1], arr[row+1][col+1]) + arr[row][col];
                }
                else if ( row == dp.length -1) {
                    dp[row][col] = Math.max(dp[row][col+1], dp[row-1][col+1]) + arr[row][col];
                } else {
                    dp[row][col] = Math.max(dp[row][col+1], Math.max(dp[row-1][col+1], dp[row+1][col+1])) + arr[row][col];
                }
            }
        }

        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println(max);
    }
}
