package com.company.staticExample;
/*class Test {
    static String name;

    public Test(String name) {
        Test.name = name;
    }
}

 */

// outside classes cannot be static
public class InnerClasses {

//    class Test {
//       String name;    //when we are putting it inside, it is now dependent on the objects of this class
//
//        public Test(String name) {
//            this.name = name;
//        }
//    }

    static class Test {
        String name;    //when we are putting it inside, it is now not dependent on the objects of this class
                                    // dependent on the class itself and not on the objects of the class
        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);


    }


}
