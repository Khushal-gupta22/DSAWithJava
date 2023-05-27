package com.company.access;

import java.sql.SQLOutput;

public class SubCLass extends A {

    public SubCLass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubCLass obj = new SubCLass(45, "Kuna");
        obj.getNum();
        int n = obj.num;

    }
}

class SubSubClass extends SubCLass {
    public SubSubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubSubClass obj = new SubSubClass(45, "Kuna");
        obj.getNum();
        int n = obj.num;
       // Object
    }
}

class SubClas2 extends A {
    public SubClas2(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        A obj = new A(45, "Kuna");
        obj.getNum();
        int n = obj.num;

        System.out.println(obj instanceof Object);;
    }
}
