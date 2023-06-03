package com.company;

import java.util.Scanner;

public class floorTiling {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // you are given a floor of 2Xn meters and an infinite no of 2X1 tiles you have to find the total no of ways in which the floor can be tiled

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);

        // now if you are given mXn floor and infinit no of mX1 tiles then find the no of ways
        int m = scn.nextInt();

        int[] dp2 = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if ( i < m) {
                dp[i] = 1; //  all vertically placed
            } else if ( i == m) {
                dp[i] =2 ; // all vertically placed or all horizontally placed
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }

    }

}