package com.company.abstractDemo;

public class Daughter extends Parent{

    public Daughter(int age) {
        super(19);
    }

    @Override
    void career() {
        System.out.println("I am going to be a coder" );

    }

    @Override
    void partner() {
        System.out.println(" I Love Iron man" );

    }
}
