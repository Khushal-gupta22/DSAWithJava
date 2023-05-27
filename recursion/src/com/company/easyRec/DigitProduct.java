package com.company.easyRec;

public class DigitProduct {
    public static void main(String[] args) {
        int ans = prodOfDigits(4567);
    }

    static int prodOfDigits(int n) {
        if (n%10 == n) {
            return n ;
        }
        return (n%10) * prodOfDigits(n/10);
    }
}
