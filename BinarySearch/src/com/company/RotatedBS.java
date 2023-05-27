package com.company;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotatedBS {
    public static void main(String[] args) {
        int[] arr ={4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot==-1){
            //just do a normal binary search
            return binarySearch(nums, target, 0, nums.length-1);
        }

        // if pivot is found, you have 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot -1);
        }
        //case 3 when target is less than start element
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
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
        return-1;
    }
    // this will not cover/ work with duplicate values
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start) /2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid+1] ) {
                return mid;
            }
            if (arr[mid]< arr[mid-1]) {
                return mid-1;
            }
            if  (arr[mid] <= arr[start]) {
                end = mid -1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    static int findPivotwithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start) /2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid+1] ) {
                return mid;
            }
            if (arr[mid]< arr[mid-1]) {
                return mid-1;
            }

            // if elements at middle, end, start are equal , just skip the duplicates
           // if ()
            // incomplete code , will complete when able to understand
        }
        return -1;
    }

}
