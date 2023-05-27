package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        /*
           1 2 3
           4 5 6
           7 8 9
         */
        Scanner in = new Scanner(System.in);
        //   int[][] arr = new int[3][]; //int[no of rows][no of columns] //no of columns to be specified are not mandatory

//        int[][] arr = {
//                {1,2,3},
//                {4,5,6},     //consider this as an array of array
//                {7,8,9}      // at 0th index : {1,2,3} and 1st : {4,5,6} and so on
//        };
//        int[][] arr2D = {
//                {1, 2, 3}, //0th index
//                {4, 5},    //1st index
//                {6, 7, 8, 9} //2nd index -> arr2D[2]= {6,7,8,9}
//        };
        int[][] arr = new int[3][3];
        System.out.println(arr.length);
        ; //no of rows
        // input

        for (int row = 0; row < arr.length; row++) {
            //for each col in every row
            for (int col = 0; col < arr[row].length; col++) {   // ar[row].length means every array at that row
                // , the length of that array
                arr[row][col] = in.nextInt();

            }
        }
        //output
        for (int row = 0; row < arr.length; row++) {
            //for each column in every row
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();

        }
        //output
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
        //enhanced for loop
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }


    }
}