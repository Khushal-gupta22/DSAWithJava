package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {

    public static void main(String[] args) {
//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("India" , 135);
//        hm.put("China" , 200);
//        hm.put("Pak" , 30);
//        hm.put("US" , 20);
//        hm.put("UK" , 10);
//
//        System.out.println(hm);
//
//        hm.put("Nigeria" , 5);
//        hm.put("US", 25);
//        System.out.println(hm);
//
//        System.out.println(hm.get("India"));
//        System.out.println(hm.get("US"));
//
//        Set<String> keys = hm.keySet();
//        System.out.println(keys);
//
//        for (String key : hm.keySet()) {
//            Integer val = hm.get(key);
//            System.out.println(key + " " + val);
//        }
        Scanner scn = new Scanner(System.in) ;

        // highest freq of a character
        String str = scn.nextLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ( hm.containsKey(ch)) {
                int oldFreq = hm.get(ch);
                int newFreq = oldFreq + 1;
                hm.put(ch, newFreq);
            } else {
                hm.put(ch, 1);
            }
        }

        int maxFreqChar = str.charAt(0);
        for ( Character key : hm.keySet()) {
            if ( hm.get(key) > hm.get(maxFreqChar)) {
                maxFreqChar = key;
            }
        }
        System.out.println(maxFreqChar) ;

        // get common elements 1
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for ( int val: arr1) {
            if (freqMap.containsKey(val) ) {
                int oldFreq = freqMap.get(val);
                int newFreq = oldFreq + 1;
                freqMap.put(val, newFreq);

            } else {
                freqMap.put(val, 1);
            }
        }

        for ( int val : arr2) {
            if ( freqMap.containsKey(val)) {
                System.out.println(val);
                freqMap.remove(val);
            }
        }

        // get common elements 2
//        int n1 = scn.nextInt();
//        int[] arr1 = new int[n1];
//        for (int i = 0; i < n1; i++) {
//            arr1[i] = scn.nextInt();
//        }
//        int n2 = scn.nextInt();
//        int[] arr2 = new int[n2];
//        for (int i = 0; i < n2; i++) {
//            arr2[i] = scn.nextInt();
//        }
//
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        for ( int val: arr1) {
//            if (freqMap.containsKey(val) ) {
//                int oldFreq = freqMap.get(val);
//                int newFreq = oldFreq + 1;
//                freqMap.put(val, newFreq);
//
//            } else {
//                freqMap.put(val, 1);
//            }
//        }

        for (int val : arr2) {
            if (freqMap.containsKey(val) && freqMap.get(val) > 0) {
                System.out.println(val);
                int oldFreq = freqMap.get(val);
                int newFreq = oldFreq - 1;
                freqMap.put(val, newFreq);
            }
        }

        // longest common sequence of elements

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for ( int val: arr) {
            map.put(val, true);
        }

        for ( int val: arr) {
            if ( map.containsKey(val-1)) {
                map.put(val, false);
            }
        }

        int maxStartPt = 0;
        int maxLen = 0;
        for( int val: arr) {
            if ( map.get(val) == true) {
                int tempLen = 1;
                int tempStartPt = val;

                while( map.containsKey(tempStartPt + tempLen)) {
                    tempLen++;
                }

                if ( tempLen > maxLen) {
                    maxStartPt = tempStartPt;
                    maxLen = tempLen;
                }
            }
        }

        for (int i = 0; i < maxLen; i++) {
            System.out.println(maxStartPt + i);
        }

    }
}
