package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //array of primitives
        int[] arr = new int[5];
        arr[0]= 23 ;
        arr[1] = 45;
        arr[2] = 233 ;
         arr[3] = 456;
         arr[4] = 44;
         // [23, 45, 233 , 456 , 44]
        System.out.println(arr[3]);


        // input using for loops
        for (int i =0 ; i < arr.length; i++) {
            arr[i] = in.nextInt() ;
        }

        System.out.println(Arrays.toString(arr));
//        //for each loop
//        for (int j : arr) {     //for every element in array , print the element.
//            System.out.print(j + " "); // here , j represents element of the array
//            //for(datatype reference variable in array ) //print that type
//            ;
//        }
        //array of objects
        String[] str= new String[4];
        for (int i = 0; i < str.length ; i++) {
            str[i] = in.next();


        }
        System.out.println(Arrays.toString(str));

        //modify
        str[1] = "khushal" ;



    }
}
