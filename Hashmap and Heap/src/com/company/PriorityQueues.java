package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueues {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int val: ranks) {
            pq.add(val);
        }

        while ( pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }

    public static void KLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if ( i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while ( pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }

    public static void KSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if ( right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if ( left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if ( right.size() - left.size()  == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if ( this.size() == 0 ) {
                System.out.println("Underflow");
                return -1;
            } else if ( left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            if ( this.size() == 0 ) {
                System.out.println("Underflow");
                return -1;
            } else if ( left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }

        }

        public int size() {
            return left.size() + right.size();
        }
    }

    public static class Pair implements Comparable<Pair> {
        int listIndex;
        int dataIndex;
        int val;

        Pair ( int listIndex, int dataIndex, int val) {
            this.dataIndex = dataIndex;
            this.listIndex = listIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists, int k) {
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
            
        }

        while ( pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.val);
            p.dataIndex++;

            if ( p.dataIndex < lists.get(p.listIndex).size()) {
                p.val = lists.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }
        
        return rv;
    }



}
