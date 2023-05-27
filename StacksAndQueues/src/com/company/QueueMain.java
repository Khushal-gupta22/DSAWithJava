package com.company;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue();
        queue.insert(3);
        queue.insert(4);
        queue.insert(64);
        queue.insert(56);
        queue.insert(17);
        queue.insert(90);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);

        queue.display();
    }
}
