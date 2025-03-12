package com.practice.leetcode.daily.mar25;

public class MaxCountPostiveNeg2529_12 {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > 0) pos++;
            else if (nums[i] < 0) neg++;
            else continue;
        }

        return Math.max(pos, neg);
    }
}
