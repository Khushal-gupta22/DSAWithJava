package com.company;
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 // find smallest character greater than the target //note that letters wrap around
//if none of the character in the array is greater than the target element, then print the 0th index
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'd', 'f', 'j'};
        char target = 'j';
        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length -1;

        while (start <= end) {
            //find he middle element
            //int mid =( start+end)/2 ; //might be possible that (start+end) exceed the range of integers in java
            int mid= start + (end-start) / 2;

            if (target< letters[mid]) {
                end = mid -1;
            } else {
                start = mid + 1;
            }

            }

        return letters[start % letters.length];
    }

}
