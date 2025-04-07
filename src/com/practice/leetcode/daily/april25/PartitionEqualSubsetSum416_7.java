package com.practice.leetcode.daily.april25;

public class PartitionEqualSubsetSum416_7 {
    // TC : O(N * target)
    // SC : O(N * target)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;

        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0 ; i < n ; i++) {
            dp[i][0] = true; // 0 target
        }
        if (nums[0] <= target) dp[0][nums[0]] = true;
        for (int index = 1 ; index < n ; index++) {
            for (int j = 0 ; j <= target ; j++) {
                boolean notPick = dp[index-1][j];
                boolean pick = false;
                if (nums[index] <= j) {
                    pick = dp[index-1][j-nums[index]];
                }
                dp[index][j] = notPick || pick;
            }
        }
        return dp[n-1][target];
        //return canPartition(n-1, nums, target, dp);
    }

    public boolean canPartition(int index, int[] nums, int target, boolean[][] dp) {
        if (target == 0) return true;
        if (index == 0) return nums[0] == target;
        if (dp[index][target]) return true;

        boolean notPick = canPartition(index-1, nums, target, dp);
        boolean pick = false;
        if (nums[index] <= target) {
            pick = canPartition(index-1, nums, target-nums[index], dp);
        }
        return dp[index][target] = notPick || pick;
    }
}
