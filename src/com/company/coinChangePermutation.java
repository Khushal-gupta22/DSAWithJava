package com.company;

import java.util.Scanner;

public class coinChangePermutation {
    // you have to now tell all the possible pairs , where order does matter ir xy and yx are different and will be count as 2

    // type-1
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int amt = 1; amt <= target; amt++) {
            for (int coin: coins) {
               if ( coin <= amt ) {
                   int remAmt = amt - coin;
                   dp[amt] = dp[amt] + dp[remAmt];
               }
            }
        }
        System.out.println(dp[target]);
    }
}
