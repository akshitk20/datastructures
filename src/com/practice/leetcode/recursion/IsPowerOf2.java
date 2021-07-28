package com.practice.leetcode.recursion;

public class IsPowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        else
            return ((n%2 == 0) && isPowerOfTwo(n/2));

    }
}
