package com.company;

import java.util.Scanner;

public class maxSumSubsets {
    // given a no n and n no of elements you have to take those elements in the subset which are non-adjacent. Out of those subsets you have to find what's the maximum sum of those subsets
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] include = new int[n];
        int[] exclude = new int[n];

        include[0] = arr[0];
        exclude[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            include[i] = arr[i] + exclude[i - 1];
            exclude[i] = arr[i] + Math.max(include[i - 1], exclude[i - 1]);
        }
        System.out.println(Math.max(include[include.length -1], exclude[exclude.length-1]));
        // O(n) space complexity
        // or to reduce space complexity just take four variables
        // constant space complexity
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length; i++) {
            int newInc = exc + arr[i];
            int newExc = Math.max(inc, exc) + arr[i];
            exc = newExc;
            inc = newInc;
        }
        System.out.println(Math.max(exc, inc));
    }
}
