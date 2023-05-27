package com.company.easyRec;

// Question : No of steps to reduce a number to zero
// in one step, if the number is even , you have to divide it by 2, otherwise,
//you have to subtract 1 from it 

public class Steps {
    public static void main(String[] args) {

    }

    public int numberOfSteps(int num) {
        return  helper(num, 0);
    }

    private int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if (num % 2 == 0) {
           return helper(num/2, steps+  1);
        }
        return helper(num-1, steps+1);
    }
}
