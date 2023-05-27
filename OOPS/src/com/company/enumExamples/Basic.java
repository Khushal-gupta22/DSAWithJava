package com.company.enumExamples;

public class Basic {
    enum Week implements A{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these ae enum constants
        //public, static and final
        // since these are final, you can't create child enums
        // type is week

       //abstract are not allowed  a body is reqd
        void display() {

        }

        Week() {
            System.out.println("Constructor called for"  + this);
        }

        @Override
        public void hello() {

        }
        // this is not public or protected, only private or default
        // why? we don't want to create new objects
        // this is not enum concept that's why

        // internally : public static final Week Monday = new Week() ;
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
        week.hello();
        System.out.println(Week.valueOf("Monday"));

//        for ( Week day : Week.values()) {
//            System.out.println(day);
//        }

        // System.out.println(week.ordinal());
    }
}
