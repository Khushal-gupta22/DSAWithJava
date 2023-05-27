package com.company;

public class Main {

    public static void main(String[] args) {
        // Q : store a roll number
        int a = 19;

        //Q: store a person's name
        String name = "Khushal";

        //An array is a collection of datatypes - whatever you want to store can be stored in an array

        //syntax
        //datatype[] variable_new = new datatype[size];
        // store 5 roll nos  :
//        int[] rnos = new int[5]; // this datatype represents which type of data is stored in an array
//        //or directly
//        int[] rnos2= {23,12,45,34,15}; //all the type of data in an array should be same
//          primitives(int, char , boolean, etc..)  are stored in stack memory rest (non-primitives) are stored in heap memory
        // non primitives are the one that can be broken down ex : Array , string , etc
        int[] ros ; //declaration of ann array . ros is getting defined in the stack
        ros = new int[5]; // initialisation : actually here object is being created in the memory (heap)
        // internally by default when nothing is given by default int[5] = [0,0,0,0,0]
        System.out.println(ros[1]);

        String[] arr = new String[4];  //by default its null
        System.out.println(arr[0]);


    }
}
