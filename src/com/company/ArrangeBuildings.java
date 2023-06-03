package com.company;

import java.util.Scanner;

public class ArrangeBuildings {
    // you have to arrange buildings such that no two buildings are together but two spaces are together Also there is a road in between, so we have two spaces to put buildings and space
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        long oldCountBuildings = 1; long oldCountSpace = 1;
        for (int i = 2; i <= n; i++) {
            long newCountBuilding = oldCountSpace;
            long newCountSpace = oldCountSpace + oldCountBuildings;
            oldCountSpace = newCountSpace;
            oldCountBuildings = newCountBuilding;
        }

       long ans = oldCountBuildings + oldCountSpace;
        System.out.println(ans*ans);
    }
}