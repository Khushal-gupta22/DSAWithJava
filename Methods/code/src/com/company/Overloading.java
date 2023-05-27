package com.company;

public class Overloading {
    public static void main(String[] args) {
        fun(67);                             // this happens at compile time
        fun("Kunal");
        int ans = sum(3,4);
        System.out.println(ans);
      //  int ans = sum(2,3,4);
        System.out.println(ans);
        /*
        for function overloading , either the number of arguments should be different
        or  the type of arguments should be different
         */
    }

    static int sum(int a , int b) {
        return a+b;
    }

    static int sum(int a , int b , int c) {
        return a +b+c ;
    }

    static void fun(int a ) {
        System.out.println("first one");
        System.out.println(a);


    }

    static void fun(String name) {
        System.out.println("second one");
        System.out.println(name);

    }
}
