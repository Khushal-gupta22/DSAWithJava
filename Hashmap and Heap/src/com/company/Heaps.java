package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Heaps {
     public static class MinHeap {
         ArrayList<Integer> data;

         public MinHeap() {
             data = new ArrayList<>();
         }

         public void add(int val) {
             data.add(val);
             upHeapify(data.size() - 1);
         }

         private void upHeapify(int idx ) {
             if ( idx == 0 ) {
                 return;
             }
             int parentIdx = (idx-1)/2;
             if ( data.get(idx) < data.get(parentIdx)) {
                 swap(idx, parentIdx);
                 upHeapify(parentIdx);
             }
         }

         private void swap(int i, int j) {
             int ith = data.get(i);
             int jth = data.get(j);
             data.set(i, jth);
             data.set(j, ith);
         }

         public int remove() {
             if (this.size() == 0) {
                 System.out.println("Underflow");
                 return -1 ;
             }
             swap(0, data.size() -1 );
             int val = data.remove(data.size() - 1 );
             downHeapify(0);
             return val;
         }

         private void downHeapify(int parentIdx) {

             int mini = parentIdx ;
             int leftIdx = 2 * parentIdx + 1;
             if ( leftIdx < data.size() && data.get(leftIdx) < data.get(mini)) {
                 mini = leftIdx;
             }
             int rightIdx = 2 * parentIdx + 2;
             if ( rightIdx < data.size() && data.get(rightIdx) < data.get(mini)) {
                 mini = rightIdx;
             }

             if ( mini != parentIdx) {
                 swap(parentIdx, mini);
                 downHeapify(mini);
             }
         }

         public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1 ;
            }
            return data.get(0);
         }

         public int size() {
             return data.size();
         }
     }

    public static class MaxHeap {
        ArrayList<Integer> data ;


        public MaxHeap() {
            data = new ArrayList<>();
        }

        public void print() {
            for (int i = 0; i < data.size(); i++) {
                System.out.print(data.get(i) + " ");
            }
        }

        public void add(int val) {
            data.add(val);
            upHeapify(data.size() -1);
        }

        private void upHeapify(int idx ) {
            if ( idx == 0 ) {
                return;
            }
            int parentIdx = (idx-1)/2;
            if ( data.get(idx) > data.get(parentIdx)) {
                swap(idx, parentIdx);
                upHeapify(parentIdx);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove () {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1 ;
            }

            swap(0, data.size() -1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        private void downHeapify(int parentIdx) {
            int max = parentIdx ;
            int leftIdx = 2 * parentIdx + 1;
            if ( leftIdx < data.size() && data.get(leftIdx) > data.get(max)) {
                max = leftIdx;
            }
            int rightIdx = 2 * parentIdx + 2;
            if ( rightIdx < data.size() && data.get(rightIdx) > data.get(max)) {
                max = rightIdx;
            }

            if ( max != parentIdx) {
                swap(parentIdx, max);
                downHeapify(max);
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1 ;
            }
            return data.get(0);
        }

        public int size() {
            return data.size() ;
        }

        public void create() {
            for (int i = data.size()/2 ; i < 0; i--) {
                downHeapify(i);
            }
            for (int i = 0; i < data.size(); i++) {
                System.out.print(data.get(i) + " ");
            }
        }

    }

    public static void main(String[] args) {
         MaxHeap maxHeap = new MaxHeap();
         maxHeap.add(3);
         maxHeap.add(68);
         maxHeap.add(23);
         maxHeap.add(21);
         maxHeap.add(45);
         maxHeap.add(69);
         maxHeap.add(43);
         maxHeap.add(12);
         maxHeap.add(7);
        System.out.println(maxHeap.peek());
        maxHeap.print();
        maxHeap.add(85);
        System.out.println();
        maxHeap.print();
        maxHeap.remove();
        System.out.println();
        maxHeap.print();
        System.out.println();
     }


}
