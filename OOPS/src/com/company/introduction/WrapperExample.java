package com.company.introduction;

public class WrapperExample {
    public static void main(String[] args) {
   //     int a = 10;

    //    Integer num = 45;

        Integer a = 45;
        Integer b = 6;

        swap (a, b) ;
        System.out.println(a + " " + b);

//        final int bonus = 2;
//        bonus = 3; // giving an error since you can't modify it

        final A kunal = new A("kunal Kushwaha" ) ;
        kunal.name = "other name";


        // when a non primitive is final, you cannot reassign it .
        // kunal = new A("new objet" ) ;
        
        A obj;

        for (int i = 0; i < 10000; i++) {
            obj = new A("random name");
            
        }

    }


    static void swap (Integer a, Integer b) {
        Integer temp = a;
        a= b ;
        b= temp;
    }


}

class A {
    final int num = 10;
    String name ;

    public A(String name) {
        System.out.println("Object is created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This object is destroyed");
    }
}
