package com.company.easyRec;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1098));
    }

    static int sumOfDigits(int n) {
        if (n==0) {
            return 0 ;
        }
        return (n%10) + sumOfDigits(n/10);
    }
}
