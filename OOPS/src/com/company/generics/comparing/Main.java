package com.company.generics.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student kunal = new Student(12, 45.6f);
        Student rahul = new Student(9, 56.7f);
        Student arpit = new Student(1, 77.6f);
        Student karan = new Student(13, 69.7f);
        Student rohan = new Student(32, 43.6f);

        Student[] list = {kunal, rahul, arpit, karan, rohan};

        System.out.println(Arrays.toString(list));
        //it compared acc to marks as it was in compreTo method ;

        //the more direct way :
//        Arrays.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int)(o1.marks - o2.marks); put - inf int for descending
//            }
//        });
//        System.out.println(Arrays.toString(list));

        // more simplified way === lambda expressions
        Arrays.sort(list, (o1, o2) -> {
            return (int)(o1.marks - o2.marks); //put - inf int for descending
        });
        System.out.println(Arrays.toString(list));



        if (kunal.compareTo(rahul) < 0 ) {
            System.out.println("Rahul has more marks");

        }
    }
}
