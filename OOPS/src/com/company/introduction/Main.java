package com.company.introduction;

public class Main {

    public static void main(String[] args) {
        //store 5 roll nos
        int[] numbers = new int[5];

        //store 5 names
        String[] names = new String[5];

        // data of 5 students : {roll no, names, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5];

//        Student kunal ;  //declared
//        kunal = new Student();

        Student kunal = new Student(14, "kunal", 55.7f) ;
        Student rahul = new Student();
//        kunal.rno = 17;
//        kunal.name= "Kunal Kushwaha";
//        kunal.marks = 88.5f;

        kunal.greeting();
        kunal.changeName("shoe lover");

        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);

        Student random = new Student(kunal);
        System.out.println(random.name);

        Student random2 = new Student() ;
        System.out.println(random2.name);


    }
}

class Student {
    int rno;
    String name;
    float marks;

    // this is basically a template

    // we need a way to add the values of the above
    // properties object by object

    // we need one word to access every object

    void greeting() {
        System.out.println("Hello ! My name is : " + name);
    }

    void changeName(String name) {
        this.name = name;
    }

    Student( Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.rno;
    }

    Student() {
//        this.rno = 17;
//        this.name = "Kunal Kushwaha";  //internally "this" gets replaced with kunal
//        this.marks = 88.5f;
        // internally: new Student (13, "default", 100.0f);
        this (13, "default" , 100.0f);
    }


    // Student arpit = new Student(17, "arpit" , 78.6f)
    //here this will be replaced by arpit
    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;


    }

}