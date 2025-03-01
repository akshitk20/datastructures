package com.practice.leetcode.daily.mar25;

public class ApplyOperations2460_1 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0 ; i < nums.length-1 ; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        int k = 0;
        int[] ans = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != 0) {
                ans[k++] = nums[i];
            }
        }
        for (int i = k ; i < nums.length ; i++) {
            ans[k] = 0;
        }
        return ans;
    }
}
