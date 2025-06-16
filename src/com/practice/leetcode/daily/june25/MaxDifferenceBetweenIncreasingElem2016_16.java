package com.practice.leetcode.daily.june25;

public class MaxDifferenceBetweenIncreasingElem2016_16 {
    public int maximumDifference(int[] nums) {
        int max = -1;

        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i+1 ; j < nums.length ; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, nums[j]-nums[i]);
                }
            }
        }
        return max;
    }
}
