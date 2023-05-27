package com.company.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSet {
    public static void main(String[] args) {

    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for (int j = 0; j < arr.length; j++) {
            start = 0;
            // if current and previous elementr is same, s= e+1
            if (j > 0 && arr[j] == arr[j + 1]) {
                start = end + 1;
            }
                int n = outer.size();
                for (int i = 0; i < n; i++) {
                    List<Integer> internal = new ArrayList<>(outer.get(i));
                    internal.add(arr[j]);
                    outer.add(internal);
                }
            }

            return outer;
        }

}



