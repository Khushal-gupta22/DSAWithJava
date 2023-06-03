package com.company;

import java.util.Scanner;

public class friendsPairing {
    // you are given there are n no of friends, you have to find the no of ways in which they can either be kept single or have them paired
    // for example if there are 3 friends 1, 2, 3 then 1-2-3, 12-3, 13-2, 23-1, are the possible ways total 4
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
    }
}