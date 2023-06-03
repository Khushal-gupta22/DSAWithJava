package com.company;

import java.util.Scanner;

public class countSubsequences {
    // count subsequences of the form a+b+c+ ie a^ib^ic^i or all a's should be together then all b's should be together then all c's should be together
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ( ch == 'a') {
                a = 2*a + 1;
            } else if ( ch== 'b') {
                ab = 2*ab + a;
            } else if ( ch == 'c') {
                abc = abc  /*(jinke peeche c nhi juda)*/ + abc /*(// jinke peeche c jud gaya)*/ + ab /*(ab inpe bhi c jud gaya )*/ ;
            }
        }

        System.out.println(abc);
    }
}
