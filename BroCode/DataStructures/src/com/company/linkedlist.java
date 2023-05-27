package com.company;

import java.util.LinkedList;

public class linkedlist {
    public static void main(String[] args) {

        // **************************************************************************
         /*  LinkedList = stores nodes in two parts (data + address)
                        nodes are non consecutive memory locations
                        Elements are linked using pointers
                                            singly Linked list
                                     Node                   Node                Node
                                 [data | address ] -> [data |  address] -> [data| address]

                                               doubly Linked List
                                        Node                         Node
                         [address | data | address ] <-> [address | data | address]

                         advantages ?
                         1. Dyanamic Data Structure (allocations needed memory while running )
                         2. Insertion and deletion of nodes is easy . O(1)
                         3. No/low memory waste
          */


        LinkedList<String> linkedList = new LinkedList<String>();

        /*
        // linkedlist as a queue
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C" );
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();

         */

        // linkedlist as a queue
        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C" );
        linkedList.offer("D");
        linkedList.offer("F");
        //linkedlist.poll();

        linkedList.add(4, "E");
        linkedList.remove("E");

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        linkedList.addFirst("0");
        linkedList.addLast("G");
        String first = linkedList.removeFirst();
        String last = linkedList.removeLast();

        System.out.println(linkedList);

    }
}
