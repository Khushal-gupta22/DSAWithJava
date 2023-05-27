package com.company;

import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {
	// stack - LIFO data str.
        //     stores objects into a sort of "vertical tower"
        //     push() to add to the top
        //     pop() to remove from the top

        Stack<String> stack = new Stack<String>();


        stack.push("minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");

        // String myfavegame = stack.pop();
        //simply use peek to see the very first item in the stack
        System.out.println(stack.peek());
        //System.out.println(stack.search("Fallout76"));
        //it will return -1 as not in the atack
        // stack can run out of memory too


        // uses of stack ?
//         1. indo/redo features in text editor
//         2. moving back./forward during browser history;
//         3. backtracking algorithms (maze, file directories)
//         4. calling functions (call stack)
    }
}
