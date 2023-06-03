package com.company;

import java.util.Scanner;

public class partitionIntoSubsets {
    // ypu are given n no of people, and you have to tell the no of ways to distribute them into k teams
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noOfPeople = scn.nextInt();
        int noOfTeams = scn.nextInt();

        if ( noOfPeople == 0 || noOfTeams == 0 || noOfPeople < noOfTeams) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[noOfTeams+1][noOfPeople+1];
        for (int teams = 1; teams <= dp.length ; teams++) {
            for (int people = 1; people <= dp[0].length; people++) {
                if (people < teams) {
                    dp[teams][people] = 0;
                } else if (people == teams) {
                    dp[teams][people] = 1;
                } else {
                    dp[teams][people] = ((teams)* dp[teams][people - 1]) + dp[teams - 1][people - 1];
                }
            }

        }
        System.out.println(dp[noOfTeams][noOfPeople]);
    }
}
