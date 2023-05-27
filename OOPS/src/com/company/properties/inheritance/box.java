package com.company.properties.inheritance;

public class box {
    double l;
    double h;
    double w;
    // double weight

   // @Override
    static void greeting () {
         System.out.println("Hey , I'm in a box class. Greeting ");
     }

    box() {
        this.h = -1;
        this.l = -1;
        this.w = -1;
    }

    //cube
    box (double side) {

       // super(); // Object class
        this.w = side;
        this.l = side;
        this.h = side;
    }

    box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }


    box(box old) {
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;
    }


    public void information(){
        System.out.println("Running the box");
    }
}
