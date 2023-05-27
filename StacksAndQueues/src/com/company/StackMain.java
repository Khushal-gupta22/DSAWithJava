package com.company;

public class StackMain {
    public static void main(String[] args) throws StackException{
        DynamicStack stack = new DynamicStack(5);

//        stack.push(23);
//        stack.push(323);
//        stack.push(44);
//        stack.push(69);
//        stack.push(212);

//        System.out.println(stack.pop());

        stack.push(23);
        stack.push(323);
        stack.push(44);
        stack.push(69);
        stack.push(7);
        stack.push(8989);
        stack.push(333);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());





    }
}
