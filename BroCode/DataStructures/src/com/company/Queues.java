package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {


        // queue = FIFO dta structureFirst-in-First-out (ex. a line of people)
//                    a collecton designed for holding elements prior to processing
//                    Linear Data structure
//
//                    add  = enqueue, offer()
//                    remove = dequeue, poll()

        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen");
        queue.offer("chad");
        queue.offer("Steve");
        queue.offer("harold");

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

//        System.out.println(queue.peek());
//        queue.poll();
//        queue.poll();
//        queue.poll();
//        queue.poll();
//        System.out.println(queue);


        // uses of queues

        // 1. Keyboard buffer (letters should appear on the screen in the order they are pressed)
        //2. Printer queue (Prit jobs should be completed in order)
        // 3. Used in linkedlists, priorityQueues, Breadth-first search

    }
}
