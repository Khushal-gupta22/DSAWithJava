package com.company.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permutationsArraylist("", "abc"));

    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsArraylist(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsArraylist(f+ch+s, up.substring(1)));
        }

        return ans;
    }

    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return 1 ;
        }
        int count = 0;

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f+ch+s, up.substring(1));
        }
        return count ;
    }
}
