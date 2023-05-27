package com.company.access;

public class ObjectDemo {

    int num;
    String gpa;

    public ObjectDemo(int num, float name) {
        this.num = num;
        this.gpa = gpa;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    // it basically gives a number representation of an object
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(34, 22.6f);
        ObjectDemo obj2 = new ObjectDemo(12,69.420f);
        if (obj1 == obj2) {
            System.out.println("obj is less than obj2");
        }
        if (obj1.equals(obj2)) {
            System.out.println("obj1 is equal to obj2 ");
        }

       // System.out.println(obj1.hashCode());
    }


}
