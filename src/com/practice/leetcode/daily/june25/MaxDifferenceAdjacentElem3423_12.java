package com.practice.leetcode.daily.june25;

public class MaxDifferenceAdjacentElem3423_12 {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length-1 ; i++) {
            int diff = Math.abs(nums[i]-nums[i+1]);
            max = Math.max(max, diff);
        }
        max = Math.max(max, Math.abs(nums[0]-nums[nums.length-1]));
        return max;
    }
}
