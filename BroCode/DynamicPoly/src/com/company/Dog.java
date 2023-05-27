package com.company;

public class Dog extends Animal{

    @Override //considered good practise to write this
    public void speak(){
        System.out.println("*Dog goes woof*");
    }
}
