package com.company;

public class PassExample {       //in java only  pass by value (value is passed ) , not pass by reference
    public static void main(String[] args) {
        String chacha= "Iron Man" ;
        greet(chacha);
    }
    static void greet(String naam) {  // 'naam ' is only available in this function only not outside this function
        // scoping you cannot access outside this function
        System.out.println(naam);
    }
}

    /*
     primitives  : int,short , char , byte... ---- just passes value
      objects and references : passing value of the same reference variable , so bi
     */
