package com.company.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        // to print the exception in a prertty way
        // use try catch block
        try {
          //  divide(a,b) ;
//            // mimicking the exception
//            throw new Exception("Just fro fun");
            String name = "khushal" ;
            if(name.equals("khushal")) {
                throw new myException("name is khushal");
            }
        } catch (myException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) { // you have to add more strict exceptions first
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will execute always ");
        }
    }

    static int divide (int a, int b ) throws ArithmeticException {

        if (b==0) {
            throw new ArithmeticException("Please do not divide by zero" );
        }
        return a/b ;
    }
}
