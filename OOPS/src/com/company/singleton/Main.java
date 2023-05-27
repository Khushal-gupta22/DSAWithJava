package com.company.singleton;

public class Main {
    public static void main(String[] args) {
       // Singleton obj0 = new Singleton(); // since it is private you cannot create an object

        Singleton obj = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();

        Singleton obj3 = Singleton.getInstance();

        // all 3 ref variables are pointing to just one object
    }
}
