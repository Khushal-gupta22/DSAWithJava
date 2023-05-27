package com.company.strings;

public class Stream {
    public static void main(String[] args) {
//        skip("", "bcaaasd");
//        System.out.println(skip("aaaaadsd"));
        String ans = skipAWord("alpha", "ertalphaer");
        System.out.println(ans);
    }

    // p === processed ; up === unprocessed

    static void skip(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        if (ch == 'a') {
            skip(processed, unprocessed.substring(1));
        } else {
            skip(processed + ch, unprocessed.substring(1));
        }
    }

    static String skip(String up){
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);

        if (ch == 'a' ) {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }

    }

    static String skipAWord(String word, String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith(word)) {
            return skipAWord(word, up.substring(word.length()));
        } else {
            return up.charAt(0) + skipAWord(word, up.substring(1));
        }
    }

    static String skipAppNotApple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
}
