package com.company;

import java.util.Scanner;

public class coinChangeCombination {
    // given an array and denomination of coins , you have infinite no of coins of different denominations
    // you have to tell the no of combinations possible for a given sum
    // Question - in how many combinations can you pay the person

    // type-1
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int amt = scn.nextInt();
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j-arr[i]];
            }
            // bahar arr ie jisme coins pade hain unka loop islie lgaya hai kyuki usi se hi combination bni hai agar hum hrr element of dp pr 2,3, 5 || 2, 3, 5 kaa loop lgate to permutation bnjaati assume for example 2, 3, 5 hai coins and 7 sum hai
        }
        System.out.println(dp[amt]);
    }
}
