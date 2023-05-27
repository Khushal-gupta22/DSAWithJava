package com.company;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterSmallerElement {
    public static void main(String[] args) {
        int[] arr = {10, 12, 8, 9, 6, 1, 7, 4, 3, 2, 5};
        System.out.println(Arrays.toString(NSEoNRightRev(arr)));

    }

    public static int[] NGEoNRight (int[] arr) { // from right to left
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        nge[arr.length -1] = -1;
        st.push(arr[arr.length-1]);

        for (int i = arr.length -2 ; i >= 0 ; i--) {
            while(st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if ( st.size() ==  0) {
                nge[i] = -1;

            } else {
                nge[i] = st.peek();

            }
            st.push(arr[i]);
        }
        return nge;

    }

    public static int[] NGEoNRightRev(int[] arr) { // from left to right
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                int position = st.peek();
                nge[position] = arr[i];
                st.pop();
            }

            st.push(i);
        }
        while ( st.size() > 0 ) {
            int position = st.peek();
            nge[position]= -1;
            st.pop();
        }
        return nge;
    }

    public static int[] NSEoNRight(int[] arr) {
        int[] nse = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        nse[arr.length -1] = -1;
        st.push(arr[arr.length-1]);

        for (int i = arr.length -2 ; i >= 0; i--) {
            while ( st.size() > 0 && arr[i] <= st.peek()) {
                st.pop();
            }
            if ( st.size() == 0) {
                nse[i] = -1;
            } else {
                nse[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nse;
    }

    public static int[] NSEoNRightRev(int[] arr) {
        int[] nse = new int[arr.length] ;

        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < arr.length ; i++) {
            while( st.size() > 0 && arr[i] < arr[st.peek()]) {
                int position = st.peek();
                nse[position] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while ( st.size() > 0) {
            int position = st.peek();
            nse[position] = -1;
            st.pop();
        }
        return nse;
    }

    public static int[] NGEoNLeft(int[] arr) {
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);
        for (int i =1; i < arr.length; i++) {
            while(st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if ( st.size() ==  0) {
                nge[i] = -1;

            } else {
                nge[i] = st.peek();

            }
            st.push(arr[i]);
        }
        return nge;
    }

    static int[] NSEoNLeft(int[] arr) {
        int[] nse = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while ( st.size() > 0 && arr[i] <= st.peek()) {
                st.pop();
            }
            if ( st.size() == 0 ) {
                nse[i] = -1;
            } else {
                nse[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nse;
    }

    public static int[] StockSpan(int[] arr) {
         int[] span = new int[arr.length];

         Stack<Integer> st = new Stack<>();

         st.push(0);
         span[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if ( st.size() == 0) {
                span[i] = i+1;
            } else {
                span[i] = i- st.peek();
            }
        }
        return span;
    }


}
