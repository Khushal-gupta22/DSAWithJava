package com.company.generics;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

       // arr.forEach((item) -> System.out.println(item*2));

        Consumer<Integer> fun = (item) -> System.out.println(item  * 2);
        arr.forEach(fun);

        Operation sum = (a, b) -> a+b;
        Operation prod = (a, b) -> a*b;
        Operation diff = (a, b) -> a-b;
        Operation divide = (a, b) -> a/b;

        LambdaFunctions myCalculater = new LambdaFunctions();
        System.out.println(myCalculater.operate(5, 5, prod));
        System.out.println(myCalculater.operate(5, 5, sum));
        System.out.println(myCalculater.operate(5, 5, diff));
        System.out.println(myCalculater.operate(5, 5, divide));




    }

    private int operate(int a, int b , Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
    }

