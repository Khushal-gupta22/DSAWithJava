package com.company;

public class Floor {
    public static void main(String[] args) {
        int[] arr ={2, 4, 5, 9, 14, 16, 18};
        int target = 15;
        int ans = Floor(arr, target);
        System.out.println(ans);
    }

    //return the index of the largest no smaller than or equal to target
    static int Floor(int[] arr, int target){

        // but what if the largest is smaller than the smallest no
        if( target < arr[0]){
            return -1;
        }
        int start = 0;
        int end = arr.length -1;

        while (start <= end) {
            //find he middle element
            //int mid =( start+end)/2 ; //might be possible that (start+end) exceed the range of integers in java
            int mid= start + (end-start) / 2;

            if (target< arr[mid]) {
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            } else {
                //ans found
                return mid;
            }
        }
        return end;
    }
}

