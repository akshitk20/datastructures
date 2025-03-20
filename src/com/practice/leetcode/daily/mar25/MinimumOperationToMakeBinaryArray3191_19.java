package com.practice.leetcode.daily.mar25;

public class MinimumOperationToMakeBinaryArray3191_19 {
    // TC : O(N) SC : O(1) Sliding window
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0 ; i < n-2 ; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                flip(nums, i+1);
                flip(nums, i+2);
                ans++;
            }
        }
        if (nums[n-1] == 0 || nums[n-2] == 0) return -1;
        return ans;
    }
    public void flip(int[] nums, int index) {
        if (nums[index] == 0) nums[index] = 1;
        else nums[index] = 0;
    }
}
