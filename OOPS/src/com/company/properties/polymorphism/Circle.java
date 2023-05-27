package com.company.properties.polymorphism;

public class Circle extends Shapes{
    @Override // this is called annotation

    // this will run when obj of Circle is created
    // hence it is overriding the parent annotation
    void area() {
        System.out.println("Area is pi * r * r");
    }
}
