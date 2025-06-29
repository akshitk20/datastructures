package com.practice.leetcode.daily.june25;

import java.util.Arrays;

public class NumOfSubseqSatifyGivenCond1498_29 {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int l = 0 , r = n-1, ans = 0;
        int mod = (int) 1e9 + 7;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            power[i] = (power[i-1] * 2) % mod;
        }
        Arrays.sort(nums);
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                int diff = r-l;
                ans = (ans % mod + power[diff] % mod) % mod;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
