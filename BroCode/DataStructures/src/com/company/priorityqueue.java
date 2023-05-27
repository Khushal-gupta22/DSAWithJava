package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityqueue {
    public static void main(String[] args) {

        // Priority queue = A FIFO data structure that serves elements
        //                  with the highest priorities frist
        //                  before elelments with lower priority

        Queue<Double> queue = new LinkedList<>();

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);


        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
            System.out.println(queue);
        }


        Queue<Double> queue1 = new PriorityQueue<>();

        queue1.offer(3.0);
        queue1.offer(2.5);
        queue1.offer(4.0);
        queue1.offer(1.5);
        queue1.offer(2.0);

        while(!queue1.isEmpty()) {
            System.out.println(queue1.poll());
            System.out.println(queue1);
            // permits all in ascending order
        }



    }
}
