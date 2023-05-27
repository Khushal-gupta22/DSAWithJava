package com.company;

//import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(17);
        list.insertFirst(8);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(3);

        list.display();
        list.replace(89, 3);
        list.insert(67, 2);
        list.display();
        list.insertRec(88, 2) ;
//
//        DLL list = new DLL();
//        list.insertFirst(17);
//        list.insertFirst(8);
//        list.insertFirst(2);
//        list.insertFirst(4);
//        list.insertFirst(3);
//        list.display();
//        list.insertLast(22);
//        list.display();
//        list.insertAfter(2,55);
//        list.display();
//    }

//        CLL list = new CLL();
//        list.insert(1);
//        list.insert(33);
//        list.insert(69);
//        list.insert(420);
//        list.insert(80085);
//        list.insert(223);
//        list.display();
//        list.delete(69);
//        list.display();


    }


//        LinkedList<Integer> list  = new LinkedList<>();
//        list.add(56);


}

