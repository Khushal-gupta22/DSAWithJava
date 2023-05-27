package com.company;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/
public class mountain {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8,5,3};
        int target = 8;
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);

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
        //in the end, start== end and pointing to the largest number because of the 2 checks above
        // start and end are always tying to find max element in the above two checks
        //hence, when they are pointing to just one element, that is the max becoz that is what the checks say
        // more elaboration : at every point of time for start and end , they have the best possible ans till that time
        // and if we are syain that only 1 item is remaining, hence cuz of above line that is the best possible answer
        return start; // or return end as both are equal
    }

}
