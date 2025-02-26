package com.practice.leetcode.daily.feb25;

public class MaxAbsoluteSumSubarray1749_26 {
    // TC: O(N)
    public int maxAbsoluteSum(int[] nums) {
        int premax = 0;
        int premin = 0;
        int[] prefix = new int[nums.length];
        //int prefix = 0;
        prefix[0] = nums[0]; // first element remain same
        for (int i = 1 ; i < prefix.length ; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int i = 0 ; i < nums.length ; i++) {
            //prefix += nums[i];
            premax = Math.max(premax, prefix[i]);
            premin = Math.min(premin, prefix[i]);
        }
        return premax-premin;
    }
}
