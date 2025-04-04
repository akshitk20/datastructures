package com.practice.leetcode.daily.april25;

public class MaxTripletValueII2874_3 {

    // TC : O(N)
    // todo: redo after doing greedy
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long prefixMax = nums[0];
        long diff = 0;
        for (int i = 1 ; i < nums.length ; i++) {
            ans = Math.max(ans, diff * nums[i]);
            diff = Math.max(diff, prefixMax-nums[i]);
            prefixMax = Math.max(prefixMax, nums[i]);
        }
        return ans;
    }

}
