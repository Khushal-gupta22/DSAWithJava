package com.company;

import java.util.Arrays;

public class VarAngs {
    public static void main(String[] args) {
//      fun();
 //       multiple(2,3,"Kunal", "Rahul");
 //       demo(2,3,4);
 //       demo("kunal" "Rahul" )
 //       demo() it will give error as it don't one which one to run
    }

    static void demo(int ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b, String... v) {  //Variable arguments have to be at last
    }

   static void fun(int ...v) {
       System.out.println(Arrays.toString(v));
   }

    }

