package com.practice.leetcode.daily.may25;

public class DivisibleNonDivisibleSum2894_27 {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1 ; i < n+1 ; i++) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }
        return num1 - num2;
    }
}

