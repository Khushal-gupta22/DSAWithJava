package com.company.properties.inheritance;

public class Main {
    public static void main(String[] args) {
        box box1 = new box(1, 2, 3);
        box box2 = new box(box1);
//        System.out.println(box1.l + " " + box1.h + " " + box1.w);

//        boxWeight box3 = new boxWeight();
//        boxWeight box4 = new boxWeight(1, 2, 3, 8);
//        System.out.println(box3.h + " " + box3.weight);
//
//        box box5 = new boxWeight(1,2, 3, 4);
//        System.out.println(box5.w);
       // System.out.println(box5.weight);
        // it gives an error because
        // it is the type of reference variable not the type of the object that determines what members can be accessed

        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. boxWeight
        // hence you should have access to weight variable
        // this also means, that the ones you are trying to access shoukd be initialised as well
        // but here when obj itself is of type parent class, how will you call the constructor
        // this is why error
//        boxWeight box6 = new box(1, 2, 3);
//
//        System.out.println(box6);


       // BoxPrice box = new BoxPrice(5, 8, 22);

        boxWeight box = new boxWeight();
        boxWeight.greeting(); // you can inherit but you can't override


    }
}
