package com.practice.leetcode.daily.july25;

public class LongestSubarrayBitwiseAnd2419_30 {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        int streak = 0;
        int result = 0;

        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
                streak = 0;
                result = 0;
            }

            if (num == maxValue) {
                streak++;
            } else {
                streak = 0;
            }
            result = Math.max(result,streak);
        }
        return result;
    }
}
