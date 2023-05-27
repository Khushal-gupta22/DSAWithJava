package com.company;

public class Cat extends Animal{

    @Override //considered good practise to write this
    public void speak(){
        System.out.println("*Cat goes meow*");
    }
}
