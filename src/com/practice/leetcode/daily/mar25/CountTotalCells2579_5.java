package com.practice.leetcode.daily.mar25;

public class CountTotalCells2579_5 {
    // TC : O(N)
    public long coloredCells(int n) {
        return (long) Math.pow(n,2) + (long) Math.pow(n-1,2);
    }
}
