package com.company;

public class Interpolationsearch {
    public static void main(String[] args) {


        //interpolation search = improvement over binary search BEST USED FOR "unifromly" distributed data
        // "guessses" where a value might be based on calculated probe results
        // if probe is incorrecrt, search area is  narrower, and a new probe is calculated

        // average case : O(log(log n)))
        // worst case : O(n) [values increse exponentially]

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = interpolSearch(arr, 8);
    }



    private static int interpolSearch(int[] arr, int value) {

        int high = arr.length-1;
        int low = 0;

        while (value >= arr[low] && value <= arr[high] && low <=high) {

            int probe = (high-low) *( value - arr[low]) / (arr[high]-arr[low]);
        }
        return 0;
    }
}
