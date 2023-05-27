package com.company;

import java.util.LinkedList;

public class LL {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail; //benefit of taking extra variable ->
    // if want to insert/deletelast or do anything at last,
    //  at last can do it on constant time complexity
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertLastWithoutTail(int value) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(value);
        temp.next = node;
        size++;

    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void replace(int val, int index) {
        if (index == 0) {
            deleteFirst();
            insertFirst(val);
            return;
        }
        if (index == size) {
            deleteLast();
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        node.next = temp.next.next;
        temp.next = node;

        //OR
//        delete(index);
//        insert(val, index);
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node temp = head;
        for (int index = 0; index < size - 2; index++) {
            temp = temp.next;
        }                                                  //apne tareeke se bhi sochio
        int val = temp.next.value;
        tail = temp;
        tail.next = null;
        size--;
        return val;

      /*  Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;

       */
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;


       /* Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;           //using the get function (obtained the index)
        size--;                             //but the get function can be made here only
        return val;

        */
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // insert using recursion
    public void insertRec(int value, int index) {
        head = insertRec(value, index, head);
    }

    private Node insertRec(int value, int index, Node node) {
        if (index == 0) {
//            Node temp = new Node(value, node);
//            size++;
//            return temp;
            // OR
            Node temp = new Node(value);
            size++;
            temp.next = node;
            return temp;

        } else {
            node.next = insertRec(value, index - 1, node.next);
            return node;
        }
    }


    //QUESTIONS
    public static void main(String[] args) {
//        LL first = new LL();
//        LL second = new LL();
//        LinkedList<Integer> list1 = new LinkedList<>();
//
//
//
//        first.insertFirst(1);
//        first.insertFirst(2);
//        first.insertFirst(3);
//        first.insertFirst(4);
//        first.insertFirst(5);
//
//        first.insertLastWithoutTail(6);
//
//        first.display();
//
//        first.insertLast(1);
//        first.insertLast(3);
//        first.insertLast(5);
//        first.insertLast(8);
//
//        second.insertLast(1);
//        second.insertLast(4);
//        second.insertLast(6);
//        second.insertLast(9);
//        second.insertLast(14);
//
//
//
//        LL ans = LL.merge(first, second);
//        ans.display();

        LL list = new LL();
        list.insertFirst(6);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
//        list.inPlaceReverse(list.head);
        list.kReverse(2);
        list.display();

    }

    //question1 - remove duplicates from the LL
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    //question2 - merge two sorted LL
    public static LL merge(LL first, LL second) {
        Node fh = first.head;
        Node sh = second.head;

        LL ans = new LL();

        while (fh != null && sh != null) {
            if (fh.value < sh.value) {
                ans.insertLast(fh.value);
                fh = fh.next;
            } else {
                ans.insertLast(sh.value);
                sh = sh.next;
            }
        }

        while (fh != null) {
            ans.insertLast(fh.value);
            fh = fh.next;
        }
        while (sh != null) {
            ans.insertLast(sh.value);
            sh = sh.next;
        }
        return ans;
    }

    //Question3 Recursion reverse
//    private void reverseal(Node node) {
//        if (node == tail) {
//            head = tail;
//            return;
//        }
//        reverseal(node.next);
//        tail.next = node;
//        tail = node;
//        tail.next = null;
//    }

//    // in place reversal of linkedlist
//    public void reverse() {
//        if(size <2) {
//            return;
//        }
//
//        Node prev = null;
//        Node present = head;
//        Node next = present.next;
//
//        while(present != null) {
//            present.next = prev;
//            prev = present;
//            present = next;
//            if(next != null) {
//                next = next.next;
//            }
//        }
//        head = prev;
//    }

    public boolean llCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int llCycleLength(Node head) {
        Node fast = head;
        Node slow = head;

        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node temp = slow;
                do {
                    temp = temp.next;
                    count++;
                } while (temp != fast);
            }
        }
        return count;
    }

    public Node detectCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = llCycleLength(slow);
                break;
            }
        }

        // find the start node
        Node first = head;
        Node second = head;

        while (length > 0) {
            second = second.next;
            length--;
        }

        if (length == 0) {
            return null;
        }
        // keep moving both forward till they meet at cycle start
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public boolean isHappy(int n) {
        int fast = 0;
        int slow = 0;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number = number / 10;
        }
        return ans;
    }

    public static Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    // recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public void inPlaceReverse(Node node) {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        head = prev;
    }

    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node newEnd = current;
        Node next = current.next;

        // reverse between left and right

        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node reReverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.value != headSecond.value) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reReverseHead);

        return head == null || headSecond == null;
    }

    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);

        Node headFirst = head;
        Node headSecond = reverseList(mid);

        // rearrange now just
        while (headFirst != null && headSecond != null) {
            Node temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        // as headFirst is now at last so next of tail to null
        if (headFirst != null) {
            headFirst.next = null;
        }
    }

    // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    // it's also reversing the < k end items
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    public int getLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k < 0) {
            return head;
        }

        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
            head = newLast.next;
            newLast.next = null;
        }
        return head;
    }

    public void kReverse(int k) {
        LL prev = null;

        while (this.size > 0) {
            LL current = new LL();

            if (this.size >= k) {
                for (int i = 0; i < k; i++) {
                    ;
                    int val = this.get(0).value;
                    this.deleteFirst();
                    current.insertFirst(val);
                }
                if (prev == null) {
                    prev = current;
                } else {
                    prev.tail.next = current.head;
                    prev.tail = current.tail;
                    prev.size += current.size;

                }
            } else {
                int origSize = this.size;
                for (int i = 0; i < origSize; i++) {
                    int val = this.get(0).value;
                    this.deleteFirst();
                    this.insertLast(val);
                }
            }
        }
        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

    public int kElementFromEnd(int k) {
        // constraints - use iteration, no direct/indirect use of sizeof LL , do in single traversal
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while ( fast.next != null ) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.value;
    }

    public static LL mergeSort(Node head, Node tail) {
        if ( head == tail) {
           LL baseResult = new LL();
           baseResult.insertLast(head.value);
           return baseResult;
        }

        Node mid = middleNode(head);
         LL firstHalf = mergeSort(head, mid);
         LL secondHalf = mergeSort(mid.next, tail);
         LL completeSortedList = merge(firstHalf, secondHalf);
         return completeSortedList;
    }

    public void oddEven() {
        LL odd = new LL();
        LL even = new LL();

        while (this.size > 0) {
            int val = this.head.value;
            this.deleteFirst();

            if (val % 2 == 0) {
                even.insertLast(val);
            } else {
                odd.insertLast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if( odd.size > 0 ) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    // reversing ll using pointer recursive
    private void reversePRHelper(Node node) {

        if (node == null) {
            return;
        }
        reversePRHelper(node.next);

        if (node == tail) {

        } else {
            node.next.next = node;
        }

    }
    public void reversePR() { // PR is pointer recursive
        reversePRHelper(head);
        head.next = null;
        Node temp = head;
        head = tail;
        tail = temp;
    }

    // reversing ll using data recursive

    private void reverseDRHelper(Node right, int floor) {
        if (right == null) {
            return;
        }
        reverseDRHelper(right.next, floor + 1);

        if (floor >= size / 2) {
            int temp = right.value;
            right.value = reverseLeft.value;
            reverseLeft.value = temp;
            reverseLeft = reverseLeft.next;
        }
    }

    Node reverseLeft;

    public void reverseDR() {
        reverseLeft = head;
        reverseDRHelper(head, 0);
    }

    public static int addListHelper(Node one, int placeValue1, Node two, int placeValue2, LL result) {

        if ( one == null && two == null) {
            return 0 ;
        }

        int data= 0;

        if ( placeValue1 > placeValue2) {

            int oldCarry = addListHelper(one.next, placeValue1 -1 , two, placeValue2, result);
            data = one.value + oldCarry;

        } else if ( placeValue1 < placeValue2) {

            int oldCarry = addListHelper(one, placeValue1, two.next, placeValue2 -1, result );
            data = two.value + oldCarry;

        } else {

            int oldCarry= addListHelper(one.next, placeValue1-1, two.next, placeValue2-1, result);
            data = one.value + two.value + oldCarry;
        }

        int newData = data % 10;
        int newCarry = data / 10;

        result.insertFirst(newData);
        return newCarry;
    }

    public static LL addTwoLists(LL first, LL second) {
        LL result = new LL();

        int oldCarry = addListHelper(first.head, first.size, second.head, second.size, result);
        if (oldCarry > 0) {
            result.insertFirst(oldCarry);
        }

        return result;
    }




}
