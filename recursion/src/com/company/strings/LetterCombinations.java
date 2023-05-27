package com.company.strings;

import java.util.ArrayList;

public class LetterCombinations {
    public static void main(String[] args) {

        System.out.println(lettercombinationsList("", "12"));
    }

    static void numPad(String p , String up ) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char ch = (char) ('a' + i);
            numPad(p+ch, up.substring(1));
        }
    }


    static ArrayList<String> lettercombinationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        int digit = up.charAt(0) - '0' ; // this will convert '2' into 2

        for (int i = (digit-1)*3; i < digit*3 ; i++) {

            char ch = (char) ('a' + i);
            list.addAll(lettercombinationsList(p+ch, up.substring(1)));
            
        }

        return list;
    }
}
