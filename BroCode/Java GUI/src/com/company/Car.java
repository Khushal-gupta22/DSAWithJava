package com.company;

public class Car {

    String make  ="chevrolet";
    String model = "corvette";
    int year= 2022;
    String colour= "blue";
    double price  = 50000.00;

     public String toString(){
        return make +"\n" + model +"\n" + year +"\n" + colour;

    }

    void drive() {
        System.out.println("you drive the car");
    }
    void brake() {
        System.out.println("You step on the brakes");

    }

}

