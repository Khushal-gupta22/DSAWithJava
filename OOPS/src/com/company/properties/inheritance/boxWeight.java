package com.company.properties.inheritance;

public class boxWeight extends box{
    double weight;

    public boxWeight () {
        this.weight = -1;

    }

//    static void greeting() {
//        System.out.println("Hey I'm in boxweight class" ) ;
//    }

    boxWeight(boxWeight other) {
        super(other);
        weight = other.weight;

    }

    boxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public boxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // what is this ? call the parent class constructor
        // used tyo initialise values present i n parent class

        System.out.println(super.w);
        this.weight = weight;
    }
}
