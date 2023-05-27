package com.company;

public class Comparison {
    public static void main(String[] args) {
        String a = "Kunal";
        String b = "Kunal";
        String c = a;
//        System.out.println(c == a);
        // ==
//        System.out.println(a == b);

        String name1 = new String("Kunal"); // we explicitely told java to create a new string that's
                                                    // why it gives us false
        String name2 = new String("Kunal");

        System.out.println(name1 == name2);

        System.out.println(name1.equals(name2));

    }
}
