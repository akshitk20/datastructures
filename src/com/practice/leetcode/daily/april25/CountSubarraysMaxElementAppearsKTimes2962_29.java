package com.practice.leetcode.daily.april25;

public class CountSubarraysMaxElementAppearsKTimes2962_29 {

    // O(N) : sliding window
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(n, max);
        }
        long ans = 0;
        long count = 0;
        int n = nums.length;
        int r = 0, l = 0;
        while (r < n) {
            if (nums[r] == max) {
                count++;
            }

            while (count >= k) {
                if (nums[l] == max) {
                    count--;
                }
                l++;
            }

            ans += l;
            r++;
        }
        return ans;
    }
}
