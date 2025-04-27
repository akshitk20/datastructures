package com.practice.leetcode.daily.april25;

public class CountSubarrayLengththree3392_27 {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0 ; i < n-2 ; i++) {
            if ((nums[i] + nums[i+2]) * 2 == nums[i+1]) {
                count++;
            }
        }
        return count;
    }
}
