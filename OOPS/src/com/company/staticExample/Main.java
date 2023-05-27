package com.company.staticExample;

public class Main {
    public static void main(String[] args) {
        Human kunal = new Human(22, "Kunal", 1000, false);
        Human Rahul = new Human(25, "Rahul", 15000, true);
        Human Arpit = new Human(25, "Arpit", 15000, true);

        System.out.println(Human.population);
        System.out.println(Human.population);
        System.out.println(Human.population);

        Main funn = new Main();
        funn.fun2();
    }


//        System.out.println(kunal.population);
//        System.out.println(Rahul.population);
//        System.out.println(Arpit.population);



        // whenever you are accessing, modiifying, declaring static variable
        //don't do it via the reference variable (object name) do it use it like with class




    // this is not dependent on objects
    static void fun() {
    //    greeting() ; // you can't use this because it requires an instance(object)
        // but the function you are using it in does not depend on instances

        // you can't access non static stuff without referenncing their instances in
        // a static context

        // hence, here referencing it
        Main obj = new Main();
        obj.greeting();
    }

    void fun2() {
        greeting();
    }


    // we know that something which is not static belongs to an object
    void greeting() {
 //      fun();
        System.out.println("Hello World");
    }
}
