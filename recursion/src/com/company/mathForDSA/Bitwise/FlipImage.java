package com.company.mathForDSA.Bitwise;

import java.util.Arrays;

public class FlipImage {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0},
                {1, 0, 1},
                {0, 0, 1}
        };
        int[][] ans = flipAndCovertImage(arr) ;   //we use Arrays.deepTOString to print 2-d arrays
    // M1 :System.out.println(Arrays.deepToString(ans)); // to print 2-d array in one line
        System.out.println(Arrays.deepToString(ans).replace("], ", "]\n")); // to print in array style only

//        for (int[] x : ans) {         // to print 2-d array in a matrix style
//            for  (int y : x) {
//                System.out.print(y + " " );
//            }
//            System.out.println();
//        }
    }
    private static int[][] flipAndCovertImage(int[][] image) {
        for(int[] row : image) {
            //reverse this array
            for (int i = 0; i < (image[0].length + 1) / 2; i++) {
                //swap
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length -i - 1] ^ 1;
                row[image[0].length - i -1] = temp;
            }
        }
        return image;
    }
}
