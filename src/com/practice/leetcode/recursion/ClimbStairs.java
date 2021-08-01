package com.practice.leetcode.recursion;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        else{
            int count = 0;
            count+=climbStairs(n-1);
            count+=climbStairs(n-2);
            return count;
        }
    }
}
