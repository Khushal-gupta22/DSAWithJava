package com.company;

public class Swap {
    public static void main(String[] args) {
        int a= 10;
        int b= 20;

//        //swap numbers code
//        int temp = a ;
//        a=b;
//        b=temp;
        swap(a, b);

        System.out.println(a + " " + b);

        String name= "Khushal" ;
        changeName(name) ;
        System.out.println(name);
    }
    static void changeName(String name) {
        name = "Rahul Rana";    //creating a new object
    }

    static void swap(int a , int b ){
        int temp = a;
        a=b;
        b=temp;

        //any changes you make to the variable will be valid in this function scope only.
    }
}
