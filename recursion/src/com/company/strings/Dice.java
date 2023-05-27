package com.company.strings;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {

    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target ; i++ ) {
            dice(p+i, target-1);
        }
    }

    static ArrayList<String> diceList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target ; i++ ) {
            list.addAll(diceList(p+i, target-1));
        }

        return list;
    }

    static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target ; i++ ) {
            diceFace(p+i, target-1, face);
        }
    }

    static ArrayList<String> diceListFace(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= face && i <= target ; i++ ) {
            list.addAll(diceListFace(p+i, target-1, face));
        }

        return list;
    }
}
