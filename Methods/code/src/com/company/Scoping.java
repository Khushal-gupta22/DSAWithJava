package com.company;

public class Scoping {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        String name= "Kunal" ;

//           block scope
        {
//            int a = 78; // already initialised outside the block in the same method, hence you cannot initialise again
                 a = 78;  // reassign the original ref variable to some other value
            System.out.println(a);
                 int c =99;
                 name = "Rahul";
                 //values initialised in this block, will remain in block

        }
        System.out.println(a);
        System.out.println(name);
//        system.out.println(c); // cannot use outside the block
        /* anything initialised outside the block scope cannot be initialised inside
           anything that is initialised outside you can use inside the block can update use  ,
           but anything that is initialised inside you cannot use outside
         */

        // scoping in for loops
        for (int i =0; i< 4; i++) {
            System.out.println(i);
            int num = 90;
            a = 10 ;
        }
    }

    static  void random(int marks) {
        int num = 67;
        System.out.println(num);
        System.out.println(marks);
    }
}
