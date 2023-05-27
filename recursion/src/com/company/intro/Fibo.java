package com.company.intro;

public class Fibo {
    public static void main(String[] args) {
        int ans = fibo(5);
        System.out.println(ans);

    }

    static int fibo(int n) {
        //base condition
        if (n<2) {
            return n;
        }
        return fibo(n-1) +fibo(n-2);
    }

    static long fiboFormula(int n) {
       return (long)(1/ Math.sqrt(5)* (Math.pow((1+ Math.sqrt(5)) /2, n) - Math.pow((1- Math.sqrt(5)) /2, n)));
    }
}
