package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //syntax
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(34);
        list.add(69);
        list.add(420);
        list.add(010);
        list.add(80085);          //can add as many as you want no boundation
        list.add(44);
        list.add(11);
        list.add(45);
        list.add(34);
        list.add(34);
        list.set(0,78);
        //list.set(nth index , number)

        //input
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        //  get item at any index
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));// pass index here , list[index] syntax will not work here
        }
        System.out.println(list);


    }
}             //size is fixed in an arraylist
//               say arraylist fills by some amount :
//               1: it will create a new arraylist, of say double size
//               2: old elements are copied in the new list
//               3: old one is deleted
