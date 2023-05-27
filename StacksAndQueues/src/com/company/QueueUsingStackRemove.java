package com.company;

import java.util.Stack;


public class QueueUsingStackRemove {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        System.out.println(stack.pop());
    }
        private Stack<Integer> first;
        private Stack<Integer> second;

        public void queueUsingStack() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void add(int item) {
            while ( !first.isEmpty()) {
                second.push(first.pop());
            }
            first.push(item);
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
        }

        public int remove(int item) {
            return first.pop();
        }

        public int peek() throws Exception {
            return first.peek();
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }
    }






