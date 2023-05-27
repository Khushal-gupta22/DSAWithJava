package com.company.access;

public class A {
    protected int num ;
    String name;
    int[] arr;
// private stuff can be accessed and used by using getters and setters method.
    // since private can be used in that particular file,
    // we make public class get.... to get the value, and public class set.... to set it's value
    //method is public which can be accessed from anywhere

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}
