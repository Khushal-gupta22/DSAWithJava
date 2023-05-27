package com.company.abstractDemo;

public class Son extends Parent{

    public Son(int age) {
        super(18);
    }

    @Override
    void normal() {
        super.normal();
    }

    @Override
    void career() {
        System.out.println("I am going to be a doctor" );

    }

    @Override
    void partner() {
        System.out.println(" I Love Pepper potts" );

    }
}
