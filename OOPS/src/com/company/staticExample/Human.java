package com.company.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static int population;

    static void message() {
        System.out.println("Hello World");
        // System.out.println(this.age); can't use this over here

    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population +=1;
        //it will work with "this" as well coz since it is the static variable, it is common for all.
        //checks if the object Kunal has variable population in it or not
        // no it does not -> the class has it or not - > yes it does
        //ok implement it then


    }

}

