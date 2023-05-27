package com.company;

import java.util.Scanner;
import java.util.Stack;

public class RectangleHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] rb = new int[arr.length]; // next smaller index on the right rb = rightBoundary
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        rb[arr.length-1] = arr.length;

        for( int i = arr.length - 2 ; i >=0 ; i--) {
            while ( st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if ( st.size() ==0 ) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[arr.length]; // next smaller index on the left lb = leftBoundary
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for( int i = 1 ; i < arr.length ; i++) {
            while ( st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if ( st.size() ==0 ) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if ( area > maxArea) {
                maxArea = area;
            }

        }

        System.out.println(maxArea);
    }

    public int LargestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if ( !stack.isEmpty()) {
            area = arr[popped] * i;
        } else {
           area = arr[popped] * (i-1 -stack.peek());
        }

        return Math.max(max, area);
    }
}
