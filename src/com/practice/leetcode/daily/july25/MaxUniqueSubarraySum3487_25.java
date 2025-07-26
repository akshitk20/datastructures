package com.practice.leetcode.daily.july25;

import java.util.HashSet;

public class MaxUniqueSubarraySum3487_25 {
    public int maxSum(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }
        if (set.isEmpty()) {
            for (int x : nums) {
                max = Math.max(max, x);
            }
            return max;
        }
        sum = 0;
        for (int x : set) {
            sum += x;
        }
        return sum;
    }
}
