package com.company.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(18);
        son.career();

        Parent daughter = new Daughter(19);
        daughter.career();

       // Parent mom = new Parent(45)
        Parent.hello();

    }
}
