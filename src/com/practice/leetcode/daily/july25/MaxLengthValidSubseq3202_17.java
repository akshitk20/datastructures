package com.practice.leetcode.daily.july25;

import java.util.Arrays;

public class MaxLengthValidSubseq3202_17 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[k][n];
        for (int[] d : dp) {
            Arrays.fill(d, 1);
        }
        int result = 0;
        for (int i = 1 ; i < n ; i++) {
            for (int j = 0 ; j < i ; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                result = Math.max(dp[mod][i], result);
            }
        }
        return result;
    }
}
