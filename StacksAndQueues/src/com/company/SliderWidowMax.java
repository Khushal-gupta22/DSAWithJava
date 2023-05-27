package com.company;

import java.util.Stack;

public class SliderWidowMax {
    public static void main(String[] args) {

    }

    public static void SliderWindowMaximum(int k, int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];

        st.push(arr.length-1);
        nge[arr.length -1] = arr.length;

        for (int i = arr.length -2 ; i >= 0 ; i--) {
            // - a +
            while(st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if ( st.size() ==0 ) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        int j = 0;
        for (int i = 0 ; i < arr.length -k ; i++) {
            // enter the loop to find the maximum of window starting at i
            if ( j < i ) {
                j = i;
            }
            while(nge[j] < i+ k) {
                j = nge[j];
            }

            System.out.println(arr[j]);
        }
    }
}
