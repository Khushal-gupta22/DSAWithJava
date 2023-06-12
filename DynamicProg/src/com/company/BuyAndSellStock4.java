package com.company;

import java.util.Scanner;

public class BuyAndSellStock4 {
    // type 4 of buy and sell stock , you are now given a cooldown period of one day i.e after a buy and sell you can buy the stock after a day
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int oldBoughtStatePoint = -arr[0];
        int oldSoldStatePoint = 0;
        int oldCooldownStatePoint = 0;

        for (int i = 1; i < arr.length; i++) {
            int newBoughtStatePoint = 0;
            int newSoldStatePoint = 0;
            int newCooldownStatePoint = 0;
            if ((oldCooldownStatePoint - arr[i]) > oldBoughtStatePoint) {
                newBoughtStatePoint = (oldCooldownStatePoint - arr[i]);
            } else {
                newBoughtStatePoint = oldBoughtStatePoint;
            }
            if ((oldBoughtStatePoint + arr[i]) > oldSoldStatePoint) {
                newSoldStatePoint = (oldBoughtStatePoint + arr[i]);
            } else {
                newSoldStatePoint = oldSoldStatePoint;
            }
            if ( oldSoldStatePoint > oldCooldownStatePoint) {
                newCooldownStatePoint = oldSoldStatePoint;
            } else {
                newCooldownStatePoint = oldCooldownStatePoint;
            }
            oldBoughtStatePoint = newBoughtStatePoint;
            oldSoldStatePoint = newSoldStatePoint;
            oldCooldownStatePoint = newCooldownStatePoint;
        }
        System.out.println(oldSoldStatePoint);
    }
}
