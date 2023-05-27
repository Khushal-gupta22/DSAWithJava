package com.company;

public class SearchInMountain {
    public static void main(String[] args) {
        int[] arr = {2,4,8,10,33,19,15,11,5,1};
        int target = 10;
        int ans= search(arr, target);
        System.out.println(ans);

    }
    // https://leetcode.com/problems/find-in-mountain-array
    static int search(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0 , peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // try to search in second half
        return orderAgnosticBS(arr, target, peak+1, arr.length-1);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are n decreasing part of the array
                //this may be the answer but look at left as well
                // that's why , end!= mid-1
                end = mid;
            } else {
                // in ascending part of the array
                //look at the right
                start = mid + 1; // because we know that mid+ 1 element > middle element

            }
        }
        //int the end, start== end and pointing to the largest number because of the 2 checks above
        // start and end are always tying to find max element in the above two checks
        //hence, when they are pointing to just one element, that is the max becoz that is what the checks say
        // more elaboration : at every point of time for start and end , they have the best possible ans till that time
        // and if we are syain that only 1 item is remaining, hence cuz of above line that is the best possible answer
        return start; // or return end as both are equal
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {

        //find whether the array is sorted in ascending order or descending order
        boolean isAsc;

        isAsc= arr[start] < arr[end];

        while (start <= end) {
            //find the middle element
            //int mid =( start+end)/2 ; //might be possible that (start+end) exceed the range of integers in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;

    }
}
